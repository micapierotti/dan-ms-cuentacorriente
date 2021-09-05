package dan.tp2021.cuentacorriente.service;

import dan.tp2021.cuentacorriente.DTO.EstadoClienteDTO;
import dan.tp2021.cuentacorriente.DTO.PagoDTO;
import dan.tp2021.cuentacorriente.DTO.PedidoDTO;
import dan.tp2021.cuentacorriente.database.PagoRepository;
import dan.tp2021.cuentacorriente.domain.*;
import dan.tp2021.cuentacorriente.exception.ClientNotFoundException;
import dan.tp2021.cuentacorriente.exception.ConnectionFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;

@Service
public class PagoServiceImpl implements PagoService{

    private static final String GET_PEDIDOS_CLIENTE = "?clienteId=";
    private static final String REST_API_PEDIDO_URL = "http://localhost:9002/api/pedido/facturasCliente";

    @Autowired
    CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public Pago realizarPago(PagoDTO pago) {
        try{
            Pago pagoToSave = new Pago(pago.getIdCliente(), new Date() , pago.getMedio() );
            return pagoRepository.save(pagoToSave);
        } catch (Exception e){
            //TODO Reemplazar por logger
            System.out.println("El pago no ha podido ser registrado, intente nuevamente");
            return null;
        }
    }

    public EstadoClienteDTO estado(Integer clienteId) throws ConnectionFailException {
        EstadoClienteDTO estadoClienteDTO = new EstadoClienteDTO();

        String url = REST_API_PEDIDO_URL + GET_PEDIDOS_CLIENTE + "/"+ clienteId;
        WebClient client = WebClient.create(url);
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

        return circuitBreaker.run(() -> {
            try{
                ResponseEntity<List<PedidoDTO>> result = client.get()
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .toEntityList(PedidoDTO.class)
                        .switchIfEmpty(Mono.error(new ClientNotFoundException(clienteId)))
                        .block();

                estadoClienteDTO.setFacturas(result.getBody());
            } catch (Exception e){
                try {
                    throw new ConnectionFailException();
                } catch (ConnectionFailException ex) {
                    ex.printStackTrace();
                }
            }

            estadoClienteDTO.setPagos(pagoRepository.findPagoByIdCliente(clienteId));

            return estadoClienteDTO;
        }, throwable -> defaultEstado());
    }

    private EstadoClienteDTO defaultEstado() {
        return null;
    }
}
