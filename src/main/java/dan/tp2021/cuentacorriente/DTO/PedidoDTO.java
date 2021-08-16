package dan.tp2021.cuentacorriente.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

public class PedidoDTO {
    private Integer id;
    private Instant fechaPedido;
    private ObraDTO obra;
    private List<DetallePedidoDTO> detalle;
    //private EstadoPedido estado;
}
