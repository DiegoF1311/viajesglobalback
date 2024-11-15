package co.edu.unbosque.viajesglobalback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonRootName(value = "Service")
public abstract class ServiceDTO {
    @JsonProperty("service_name")
    @NotBlank
    private String name;
    @JsonProperty("service_description")
    @NotBlank
    private String description;
    @JsonProperty("service_price")
    @NotNull
    private Float price;
    @JsonProperty("service_availability")
    @NotNull
    private Integer availability;

    public ServiceDTO() {
    }

    public ServiceDTO(String name, String description, Float price, Integer availability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = availability;
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
}
