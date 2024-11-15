package co.edu.unbosque.viajesglobalback.repository;

import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String>{
    Customer findByEmail(String email);
}
