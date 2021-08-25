package dan.tp2021.cuentacorriente.DTO;

import dan.tp2021.cuentacorriente.domain.Cliente;
import dan.tp2021.cuentacorriente.domain.MedioPago;

import java.time.Instant;

public class PagoDTO {
    private Cliente cliente;
    private Instant fechaPago;
    private MedioPago medio;

}
