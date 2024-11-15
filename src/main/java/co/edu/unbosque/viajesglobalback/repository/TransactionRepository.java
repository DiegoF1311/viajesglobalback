package co.edu.unbosque.viajesglobalback.repository;

import co.edu.unbosque.viajesglobalback.model.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
