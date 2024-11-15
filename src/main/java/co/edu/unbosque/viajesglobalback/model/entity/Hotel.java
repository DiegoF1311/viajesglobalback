package co.edu.unbosque.viajesglobalback.model.entity;

import co.edu.unbosque.viajesglobalback.model.enums.RoomTypeEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel extends Service{
	@Column(name = "hotel_name", nullable = false)
	private String hotelName;
	@Column(name = "location", nullable = false)
	private String location;
	@Column(name = "stars", nullable = false)
	private Integer stars;
	@Column(name = "room_type", nullable = false)
	private RoomTypeEnum roomType;
	@Column(name = "additional_services", nullable = false)
	private String additionalServices;
	
	public Hotel() {
		
	}

	public Hotel(Long serviceId, String name, String description, Float price, Integer availability, Set<Package> packages, String hotelName, String location, Integer stars, RoomTypeEnum roomType, String additionalServices) {
		super(serviceId, name, description, price, availability, packages);
		this.hotelName = hotelName;
		this.location = location;
		this.stars = stars;
		this.roomType = roomType;
		this.additionalServices = additionalServices;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public RoomTypeEnum getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomTypeEnum roomType) {
		this.roomType = roomType;
	}

	public String getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(String additionalServices) {
		this.additionalServices = additionalServices;
	}
}
