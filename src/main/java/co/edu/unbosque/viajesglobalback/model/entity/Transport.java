package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.TransportTypeEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "transport")
public class Transport extends Service{
	@Column(name = "transport_type", nullable = false)
	private TransportTypeEnum transportType;
	@Column(name = "origin", nullable = false)
	private String origin;
	@Column(name = "destination", nullable = false)
	private String destination;
	
	public Transport() {
	
	}

	public Transport(Long serviceId, String name, String description, Float price, Integer availability, Set<Package> packages, TransportTypeEnum transportType, String origin, String destination) {
		super(serviceId, name, description, price, availability, packages);
		this.transportType = transportType;
		this.origin = origin;
		this.destination = destination;
	}

	public TransportTypeEnum getTransportType() {
		return transportType;
	}

	public void setTransportType(TransportTypeEnum transportType) {
		this.transportType = transportType;
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
}
