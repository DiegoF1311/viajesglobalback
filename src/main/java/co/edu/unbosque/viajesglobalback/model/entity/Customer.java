package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.NotificationTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "customer_id", nullable = false, columnDefinition = "VARCHAR(10)")
	private String customerId;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "phone", nullable = false)
	private String phone;
	@Column(name = "country", nullable = false)
	private String country;
	@Column(name = "city", nullable = false)
	private String city;
	@Column(name = "notification_preference", nullable = false)
	private String notificationPreference;
	@Column(name = "registration_date", nullable = false)
	private LocalDate registrationDate;
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
	private Set<Notification> notifications;
	@OneToOne(mappedBy = "customer")
	private CustomerCredentials credentials;
	
	public Customer() {
		
	}

	public Customer(String customerId, String firstName, String lastName, String email, String phone, String country, String city, String notificationPreference, LocalDate registrationDate, Set<Reservation> reservations, Set<Notification> notifications, CustomerCredentials credentials) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.notificationPreference = notificationPreference;
		this.registrationDate = registrationDate;
		this.reservations = reservations;
		this.notifications = notifications;
		this.credentials = credentials;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNotificationPreference() {
		return notificationPreference;
	}

	public void setNotificationPreference(String notificationPreference) {
		this.notificationPreference = notificationPreference;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Set<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

	public CustomerCredentials getCredentials() {return credentials;}

	public void setCredentials(CustomerCredentials credentials) {this.credentials = credentials;}
}
