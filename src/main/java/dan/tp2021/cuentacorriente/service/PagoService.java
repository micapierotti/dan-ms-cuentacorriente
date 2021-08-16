package dan.tp2021.cuentacorriente.service;

import dan.tp2021.cuentacorriente.domain.Pago;

public interface PagoService {

    public Pago realizarPago(Pago pago);
    public void estado(Integer clienteId);
}
