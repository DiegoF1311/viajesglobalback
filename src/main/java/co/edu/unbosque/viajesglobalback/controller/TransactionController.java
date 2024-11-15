package co.edu.unbosque.viajesglobalback.controller;

import co.edu.unbosque.viajesglobalback.model.dto.TransactionDTO;
import co.edu.unbosque.viajesglobalback.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transaction/createTransaction")
    public ResponseEntity<String> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        try {
            boolean result = transactionService.createTransaction(transactionDTO);
            if (result) {
                return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR CREATING RESERVATION");
        }
    }

    @GetMapping("/transaction/getAllTransactions")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        try {
            List<TransactionDTO> transactions = transactionService.getAllTransactions();
            if (transactions.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.status(HttpStatus.OK).body(transactions);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
