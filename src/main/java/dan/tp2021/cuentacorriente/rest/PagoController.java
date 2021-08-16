package dan.tp2021.cuentacorriente.rest;

import dan.tp2021.cuentacorriente.domain.Pago;
import dan.tp2021.cuentacorriente.service.PagoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/cuenta")
@RestController
public class PagoController {

    /*
    a. Registra un pago de un cliente
     */

    private PagoService pagoService;

    public PagoController(PagoService pago){
        this.pagoService = pago;
    }

    @PostMapping("/pago")
    public ResponseEntity<?> realizarPago(@RequestBody Pago pago){

        pagoService.realizarPago(pago);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    /*
     b. Retorna el estado de cuenta corriente de un cliente con un detalle de
        i. Pagos
        ii. Facturas (pedidos enviados)
     */

    @GetMapping("/estado/{clienteId}")
    public ResponseEntity<?> getEstadoCliente(@PathVariable Integer clienteId) {




    }
}
