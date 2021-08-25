package dan.tp2021.cuentacorriente.service;

import dan.tp2021.cuentacorriente.DTO.PedidoDTO;
import dan.tp2021.cuentacorriente.domain.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class PagoServiceImpl implements PagoService{

    private static final String GET_PEDIDOS_CLIENTE = "?clienteId=";
    private static final String REST_API_PEDIDO_URL = "http://localhost:9002/api/pedido/facturasCliente";


    @Override
    public Pago realizarPago(Pago pago) {
        MedioPago medio = pago.getMedio();

        /*
        switch (medio.getTipo()){
            case "EFECTIVO":

                pago.setMedio(new Efectivo(medio.getObservacion(),  medio.getNroRecibo()));
                break;
            case "TRANSFERENCIA":
                pago.setMedio(new Transferencia(medio.getObservacion(), medio.ge));
                break;
            case "CHEQUE":
                break;
        }

       */
        return pago;
    }

    public List<PedidoDTO> estado(Integer clienteId){
        String url = REST_API_PEDIDO_URL + GET_PEDIDOS_CLIENTE + "/"+ clienteId;
        WebClient client = WebClient.create(url);

        ResponseEntity<List<PedidoDTO>> result = client.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntityList(PedidoDTO.class)
                .or(null)
                .block();



        return result.getBody();

    }




}
