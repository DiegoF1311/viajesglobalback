package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.ReservationStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
public class Reservation {
	@Id
	@Column(name = "reservation_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reservationId;
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "package_id", referencedColumnName = "package_id")
	private Package travelPackage;
	@Column(name = "reservation_date", nullable = false)
	private LocalDate reservationDate;
	@Column(name = "status", nullable = false)
	private ReservationStatusEnum status;
	@OneToOne(mappedBy = "reservation")
    private Transaction transaction;
	
	public Reservation() {
		
	}

	public Reservation(Long reservationId, Customer customer, Package travelPackage, LocalDate reservationDate, ReservationStatusEnum status) {
		this.reservationId = reservationId;
		this.customer = customer;
		this.travelPackage = travelPackage;
		this.reservationDate = reservationDate;
		this.status = status;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Package getTravelPackage() {
		return travelPackage;
	}

	public void setTravelPackage(Package travelPackage) {
		this.travelPackage = travelPackage;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public ReservationStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ReservationStatusEnum status) {
		this.status = status;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
