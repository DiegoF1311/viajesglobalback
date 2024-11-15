package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.PaymentMethodEnum;
import co.edu.unbosque.viajesglobalback.model.enums.TransactionStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JsonRootName("Transaction")
public class TransactionDTO {
    @JsonProperty(value = "reservation_id", required = false)
    private Long reservationId;
    @JsonProperty("amount")
    @NotNull
    private Float amount;
    @JsonProperty("transaction_date")
    @NotNull
    private LocalDateTime date;
    @JsonProperty("payment_method")
    @NotNull
    private PaymentMethodEnum paymentMethod;
    @JsonProperty("transaction_status")
    @NotNull
    private TransactionStatusEnum status;

    public TransactionDTO() {}

    public TransactionDTO(Long reservationId, Float amount, LocalDateTime date, PaymentMethodEnum paymentMethod, TransactionStatusEnum status) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public TransactionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TransactionStatusEnum status) {
        this.status = status;
    }
}
