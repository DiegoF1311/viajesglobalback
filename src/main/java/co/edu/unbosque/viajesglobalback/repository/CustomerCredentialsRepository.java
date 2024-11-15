package co.edu.unbosque.viajesglobalback.repository;

import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import co.edu.unbosque.viajesglobalback.model.entity.CustomerCredentials;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCredentialsRepository extends CrudRepository<CustomerCredentials, Long> {
    public CustomerCredentials findCustomerCredentialsByCustomer(Customer customer);
}
