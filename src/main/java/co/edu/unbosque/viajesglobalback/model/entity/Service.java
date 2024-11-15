package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.ServiceTypeEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "service")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service {
	@Id
	@Column(name = "service_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceId;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "price", nullable = false)
	private Float price;
	@Column(name = "availability", nullable = false)
	private Integer availability;

	@ManyToMany(mappedBy = "services")
	Set<Package> packages;
	
	public Service() {
		
	}

	public Service(Long serviceId, String name, String description, Float price, Integer availability, Set<Package> packages) {
		this.serviceId = serviceId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.availability = availability;
		this.packages = packages;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Set<Package> getPackages() {
		return packages;
	}

	public void setPackages(Set<Package> packages) {
		this.packages = packages;
	}
}
