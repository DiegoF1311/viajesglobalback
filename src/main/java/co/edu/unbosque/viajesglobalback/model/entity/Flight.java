package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.FlightClassEnum;
import co.edu.unbosque.viajesglobalback.model.enums.ServiceTypeEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "flight")
public class Flight extends Service {
	@Column(name = "flight_number", nullable = false)
	private String flightNumber;
	@Column(name = "airline", nullable = false)
	private String airline;
	@Column(name = "origin", nullable = false)
	private String origin;
	@Column(name = "destination", nullable = false)
	private String destination;
	@Column(name = "departure_date", nullable = false)
	private LocalDateTime departureDate;
	@Column(name = "arrival_date", nullable = false)
	private LocalDateTime arrivalDate;
	@Column(name = "class", nullable = false)
	private FlightClassEnum flightClass;
	
	public Flight() {
		
	}

	public Flight(Long serviceId, String name, String description, Float price, Integer availability, Set<Package> packages, String flightNumber, String airline, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, FlightClassEnum flightClass) {
		super(serviceId, name, description, price, availability, packages);
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
