package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.TransportTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonRootName(value = "Transport")
public class TransportDTO extends ServiceDTO{
    @JsonProperty("transport_type")
    @NotNull
    private TransportTypeEnum transportType;
    @JsonProperty("origin")
    @NotBlank
    private String origin;
    @JsonProperty("destination")
    @NotBlank
    private String destination;

    public TransportDTO() {
    }

    public TransportDTO(String name, String description, Float price, Integer availability, TransportTypeEnum transportType, String origin, String destination) {
        super(name, description, price, availability);
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
