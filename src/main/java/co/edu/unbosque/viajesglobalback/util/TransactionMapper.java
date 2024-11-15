package co.edu.unbosque.viajesglobalback.util;

import co.edu.unbosque.viajesglobalback.model.dto.TransactionDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Transaction;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction entity) {
        try {
            return new TransactionDTO(
                    entity.getReservation().getReservationId(),
                    entity.getAmount(),
                    entity.getTransactionDate(),
                    entity.getPaymentMethod(),
                    entity.getStatus()
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Transaction to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Transaction toEntity(TransactionDTO dto) {
        try {
            Transaction entity = new Transaction();
            entity.setAmount(dto.getAmount());
            entity.setTransactionDate(dto.getDate());
            entity.setPaymentMethod(dto.getPaymentMethod());
            entity.setStatus(dto.getStatus());
            return entity;
        } catch (Exception e) {
            System.err.println("Error Mapping Transaction to Entity!");
            e.printStackTrace();
            return null;
        }
    }
}
