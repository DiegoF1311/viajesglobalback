package co.edu.unbosque.viajesglobalback.controller;

import co.edu.unbosque.viajesglobalback.model.dto.CustomerCredentialsDTO;
import co.edu.unbosque.viajesglobalback.model.dto.CustomerDTO;
import co.edu.unbosque.viajesglobalback.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/getCustomerInfo")
    public ResponseEntity<CustomerDTO> getCustomerInfo(@RequestParam String id) {
        CustomerDTO costumer = customerService.getCostumerInfo(id);
        if (costumer == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(customerService.getCostumerInfo(id));
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerCredentialsDTO customerDTO) {
        try {
            if (customerService.createCustomer(customerDTO)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR CREATING CUSTOMER!");
        }
    }

    @PostMapping("/logIn")
    public ResponseEntity<String> logIn(@RequestBody String[] credentials) {
        if (customerService.logIn(credentials)) {
            return ResponseEntity.status(HttpStatus.OK).body("LOGIN SUCCESS");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CREDENTIALS INCORRECT");
    }
}
