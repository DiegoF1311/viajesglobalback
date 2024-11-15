package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.RoomTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@JsonRootName(value = "Hotel")
public class HotelDTO extends ServiceDTO{
    @JsonProperty("hotel_name")
    @NotBlank
    private String hotelName;
    @JsonProperty("location")
    @NotBlank
    private String location;
    @JsonProperty("stars")
    @NotNull
    private Integer stars;
    @JsonProperty("room_type")
    @NotNull
    private RoomTypeEnum roomType;
    @JsonProperty("additional_services")
    @NotEmpty
    private Set<String> additionalServices;

    public HotelDTO() {
    }

    public HotelDTO(String name, String description, Float price, Integer availability, String hotelName, String location, Integer stars, RoomTypeEnum roomType, Set<String> additionalServices) {
        super(name, description, price, availability);
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

    public Set<String> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(Set<String> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
