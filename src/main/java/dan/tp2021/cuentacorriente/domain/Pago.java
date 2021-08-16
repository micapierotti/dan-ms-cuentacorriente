package dan.tp2021.cuentacorriente.domain;

import javax.persistence.Entity;
import java.time.Instant;
@Entity
public class Pago {

	private Integer id;
	private Cliente cliente;
	private Instant fechaPago;
	private MedioPago medio;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Instant getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Instant fechaPago) {
		this.fechaPago = fechaPago;
	}
	public MedioPago getMedio() {
		return medio;
	}
	public void setMedio(MedioPago medio) {
		this.medio = medio;
	}
	
	
}
