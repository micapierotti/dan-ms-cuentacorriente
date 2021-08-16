package dan.tp2021.cuentacorriente.database;

import dan.tp2021.cuentacorriente.domain.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepository extends CrudRepository<Pago, Integer> {

}
