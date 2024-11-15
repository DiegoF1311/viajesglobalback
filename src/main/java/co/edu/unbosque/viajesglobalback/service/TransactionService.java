package co.edu.unbosque.viajesglobalback.service;

import co.edu.unbosque.viajesglobalback.model.dto.TransactionDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Reservation;
import co.edu.unbosque.viajesglobalback.model.entity.Transaction;
import co.edu.unbosque.viajesglobalback.model.enums.TransactionStatusEnum;
import co.edu.unbosque.viajesglobalback.repository.ReservationRepository;
import co.edu.unbosque.viajesglobalback.repository.TransactionRepository;
import co.edu.unbosque.viajesglobalback.util.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean createTransaction(TransactionDTO transactionDTO) {
        Transaction transaction = TransactionMapper.toEntity(transactionDTO);
        Optional<Reservation> reservation = reservationRepository.findById(transactionDTO.getReservationId());
        if (reservation.isPresent() && transaction != null) {
            transaction.setReservation(reservation.get());
            transactionRepository.save(transaction);
            return true;
        }
        return false;
    }

    public void changeTransactionStatus(Long transactionId, String newStatus) {
        Optional<Transaction> transaction = transactionRepository.findById(transactionId);
        Transaction transactionToChange = new Transaction();
        if (transaction.isPresent()) {
            transactionToChange = transaction.get();
            transactionToChange.setStatus(TransactionStatusEnum.valueOf(newStatus));
            transactionRepository.save(transactionToChange);
        }
    }

    public List<TransactionDTO> getAllTransactions() {
        List<TransactionDTO> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(entity -> transactions.add(TransactionMapper.toDTO(entity)));
        return transactions;
    }
}
