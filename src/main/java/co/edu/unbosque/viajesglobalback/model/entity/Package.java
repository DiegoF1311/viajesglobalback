package co.edu.unbosque.viajesglobalback.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "package")
public class Package {
	@Id
	@Column(name = "package_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long packageId;
	@Column(name = "package_name", nullable = false)
	private String packageName;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "total_price", nullable = false)
	private Float totalPrice;
	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;
	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;
	@Column(name = "availability", nullable = false)
	private Boolean availability;
	@ManyToMany
	@JoinTable(
			name = "package_service",
			joinColumns = @JoinColumn(name = "package_id"),
			inverseJoinColumns = @JoinColumn(name = "service_id"))
	private Set<Service> services;
	
	public Package() {
		
	}

	public Package(Long packageId, String packageName, String description, Float totalPrice, LocalDate startDate,
			LocalDate endDate, Boolean availability, Set<Service> services) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.description = description;
		this.totalPrice = totalPrice;
		this.startDate = startDate;
		this.endDate = endDate;
		this.availability = availability;
		this.services = services;
	}

	public Long getPackageId() { return packageId; }

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Boolean getAvailability() {
		return availability;
	}

	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
}
