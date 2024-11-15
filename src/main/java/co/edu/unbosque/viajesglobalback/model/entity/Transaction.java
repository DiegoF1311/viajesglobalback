package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.PaymentMethodEnum;
import co.edu.unbosque.viajesglobalback.model.enums.TransactionStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name = "transaction_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_id")
	private Reservation reservation;
	@Column(name = "amount", nullable = false)
	private Float amount;
	@Column(name = "transaction_date", nullable = false)
	private LocalDateTime transactionDate;
	@Column(name = "payment_method", nullable = false)
	private PaymentMethodEnum paymentMethod;
	@Column(name = "status", nullable = false)
	private TransactionStatusEnum status;
	
	public Transaction() {
		
	}

	public Transaction(Long transactionId, Reservation reservation, Float amount, LocalDateTime transactionDate,
			PaymentMethodEnum paymentMethod, TransactionStatusEnum status) {
		super();
		this.transactionId = transactionId;
		this.reservation = reservation;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.paymentMethod = paymentMethod;
		this.status = status;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
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
