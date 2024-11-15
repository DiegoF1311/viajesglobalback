package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.FlightClassEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@JsonRootName(value = "Flight")
public class FlightDTO extends ServiceDTO{
	@JsonProperty("flight_number")
	@NotBlank
	private String flightNumber;
	@JsonProperty("airline")
	@NotBlank
	private String airline;
	@JsonProperty("origin")
	@NotBlank
	private String origin;
	@JsonProperty("destination")
	@NotBlank
	private String destination;
	@JsonProperty("departure_date")
	@FutureOrPresent
	private LocalDateTime departureDate;
	@JsonProperty("arrival_date")
	@FutureOrPresent
	private LocalDateTime arrivalDate;
	@JsonProperty("flight_class")
	@NotNull
	private FlightClassEnum flightClass;

	public FlightDTO() {
	}

	public FlightDTO(String name, String description, Float price, Integer availability, String flightNumber, String airline, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, FlightClassEnum flightClass) {
		super(name, description, price, availability);
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.flightClass = flightClass;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public FlightClassEnum getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(FlightClassEnum flightClass) {
		this.flightClass = flightClass;
	}
}
