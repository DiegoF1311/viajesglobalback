package co.edu.unbosque.viajesglobalback.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Set;

@JsonRootName(value = "Package")
public class PackageDTO {
    @JsonProperty("package_name")
    @NotBlank
    private final String packageName;
    @JsonProperty("package_description")
    @NotBlank
    private final String description;
    @JsonProperty("package_total_price")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Float totalPrice;
    @JsonProperty("package_start_date")
    @NotNull
    private final LocalDate startDate;
    @JsonProperty("package_end_date")
    @NotNull
    private final LocalDate endDate;
    @JsonProperty("package_availability")
    @NotNull
    private final Boolean availability;
    @JsonProperty("package_services")
    @NotNull
    @NotEmpty
    private final Set<Long> services;

    public PackageDTO() {
        this.packageName = null;
        this.description = null;
        this.totalPrice = null;
        this.startDate = null;
        this.endDate = null;
        this.availability = null;
        this.services = null;
    }

    private PackageDTO(PackageDTOBuilder builder) {
        this.packageName = builder.packageName;
        this.description = builder.description;
        this.totalPrice = builder.totalPrice;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.availability = builder.availability;
        this.services = builder.services;
    }

    public static class PackageDTOBuilder {
        private String packageName;
        private String description;
        private Float totalPrice;
        private LocalDate startDate;
        private LocalDate endDate;
        private Boolean availability;
        private Set<Long> services;

        public PackageDTOBuilder() {

        }

        public PackageDTOBuilder setPackageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public PackageDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PackageDTOBuilder setTotalPrice(Float totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public PackageDTOBuilder setStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public PackageDTOBuilder setEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public PackageDTOBuilder setAvailability(Boolean availability) {
            this.availability = availability;
            return this;
        }

        public PackageDTOBuilder setServices(Set<Long> services) {
            this.services = services;
            return this;
        }

        public PackageDTO build() {
            return new PackageDTO(this);
        }
    }

    public String getPackageName() {
        return packageName;
    }

    public String getDescription() {
        return description;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public Set<Long> getServices() {
        return services;
    }
}
