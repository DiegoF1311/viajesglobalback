package co.edu.unbosque.viajesglobalback.repository;

import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import co.edu.unbosque.viajesglobalback.model.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findAllByCustomer(Customer customer);
}
