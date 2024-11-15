package co.edu.unbosque.viajesglobalback.service;

import co.edu.unbosque.viajesglobalback.model.dto.CustomerCredentialsDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import co.edu.unbosque.viajesglobalback.model.dto.CustomerDTO;
import co.edu.unbosque.viajesglobalback.model.entity.CustomerCredentials;
import co.edu.unbosque.viajesglobalback.repository.CustomerCredentialsRepository;
import co.edu.unbosque.viajesglobalback.repository.CustomerRepository;
import co.edu.unbosque.viajesglobalback.util.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public CustomerCredentialsRepository customerCredentialsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean createCustomer(CustomerCredentialsDTO customerDTO) {
		Customer customer = CustomerMapper.toEntity(customerDTO.getCustomer());
		String encodedPassword = passwordEncoder.encode(customerDTO.getPassword());
		if (customer != null) {
			CustomerCredentials credentials = new CustomerCredentials(customer, encodedPassword);
			customerCredentialsRepository.save(credentials);
			customerRepository.save(customer);
			return true;
		}
		return false;
	}

	public boolean logIn(String[] credentials) {
		Customer customer = customerRepository.findByEmail(credentials[0]);
		if (customer == null) {
			return false;
		}
		CustomerCredentials customerCredentials = customerCredentialsRepository.findCustomerCredentialsByCustomer(customer);
		return passwordEncoder.matches(credentials[1], customerCredentials.getPassword());

	}
	
	public CustomerDTO getCostumerInfo(String id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.map(CustomerMapper::toDto).orElse(null);
	}
}
