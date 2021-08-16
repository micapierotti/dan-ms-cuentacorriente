package dan.tp2021.cuentacorriente.service;

import dan.tp2021.cuentacorriente.domain.*;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class PagoServiceImpl implements PagoService{

    private static final String GET_PEDIDOS_CLIENTE = "?idCliente=";
    private static final String REST_API_PEDIDO_URL = "http://localhost:9002/api/pedido";


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

    public void estado(Integer clienteId){
        String url = REST_API_PEDIDO_URL + GET_PEDIDOS_CLIENTE + "/"+ clienteId;
        WebClient client = WebClient.create(url);

        /*
        Mono<List<Reader>> response = webClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Reader>>() {});
        List<Reader> readers = response.block();

        return readers.stream()
                .map(Reader::getFavouriteBook)
                .collect(Collectors.toList());

        */

    }




}
