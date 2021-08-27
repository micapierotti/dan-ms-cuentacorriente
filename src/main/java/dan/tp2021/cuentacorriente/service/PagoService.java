package dan.tp2021.cuentacorriente.service;

import dan.tp2021.cuentacorriente.DTO.EstadoClienteDTO;
import dan.tp2021.cuentacorriente.DTO.PedidoDTO;
import dan.tp2021.cuentacorriente.domain.Pago;

import java.util.List;

public interface PagoService {

    public Pago realizarPago(Pago pago);
    public EstadoClienteDTO estado(Integer clienteId);
}
