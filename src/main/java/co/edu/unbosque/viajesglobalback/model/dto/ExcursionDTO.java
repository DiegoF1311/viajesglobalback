package co.edu.unbosque.viajesglobalback.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotNull;

@JsonRootName(value = "Excursion")
public class ExcursionDTO extends ServiceDTO{
    @JsonProperty("duration")
    @NotNull
    private Integer duration;

    public ExcursionDTO() {
    }

    public ExcursionDTO(String name, String description, Float price, Integer availability, Integer duration) {
        super(name, description, price, availability);
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}

