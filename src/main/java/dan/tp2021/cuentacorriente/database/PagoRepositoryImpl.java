package dan.tp2021.cuentacorriente.database;


import dan.tp2021.cuentacorriente.domain.Pago;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class PagoRepositoryImpl  {

    //Optional<List<Pago>> findByObraId(Integer idObra);

    /*@Query("select * from Pedido p where p.estado = ?1")
    List<Pedido> findByEstado(String estado);*/

}
