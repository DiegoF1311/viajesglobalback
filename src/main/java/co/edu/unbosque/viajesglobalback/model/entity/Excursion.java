package co.edu.unbosque.viajesglobalback.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "excursion")
public class Excursion extends Service{
	@Column(name = "duration", nullable = false)
	private Integer duration;
	
	public Excursion() {
		
	}

	public Excursion(Long serviceId, String name, String description, Float price, Integer availability, Set<Package> packages, Integer duration) {
		super(serviceId, name, description, price, availability, packages);
		this.duration = duration;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}
