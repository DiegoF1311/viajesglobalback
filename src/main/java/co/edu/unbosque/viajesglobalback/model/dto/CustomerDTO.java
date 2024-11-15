package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.NotificationTypeEnum;
import co.edu.unbosque.viajesglobalback.model.entity.Notification;
import co.edu.unbosque.viajesglobalback.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Set;

@JsonRootName(value = "Customer")
public class CustomerDTO {
	@JsonProperty("customer_id")
	@NotBlank
	@Size(min = 1, max = 10, message = "Customer ID must have 10 digits or less")
	private String customerId;
	@JsonProperty("first_name")
	@NotBlank
	private String firstName;
	@JsonProperty("last_name")
	@NotBlank
	private String lastName;
	@JsonProperty("email")
	@Email
	@NotBlank
	private String email;
	@JsonProperty("phone")
	@NotBlank
	@Size(min = 10, max = 10, message = "Customer Number must have 10 digits")
	private String phone;
	@JsonProperty("country")
	@NotBlank
	private String country;
	@JsonProperty("city")
	@NotBlank
	private String city;
	@JsonProperty("notification_preference")
	@NotEmpty
	private Set<NotificationTypeEnum> notificationPreference;
	@JsonProperty("registration_date")
	@NotNull
	private LocalDate registrationDate;
	
	public CustomerDTO(String customerId, String firstName, String lastName, String email, String phone, String country,
			String city, Set<NotificationTypeEnum> notificationPreference, LocalDate registrationDate) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.country = country;
		this.city = city;
		this.notificationPreference = notificationPreference;
		this.registrationDate = registrationDate;
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

	public Set<NotificationTypeEnum> getNotificationPreference() {
		return notificationPreference;
	}

	public void setNotificationPreference(Set<NotificationTypeEnum> notificationPreference) {
		this.notificationPreference = notificationPreference;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
