package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.ReservationStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonRootName("Reservation")
public class ReservationDTO {
    @JsonProperty("reservation_id")
    private Long id;
    @JsonProperty("customer_id")
    @NotBlank
    private String customerId;
    @JsonProperty("package_id")
    @NotNull
    private Long packageId;
    @JsonProperty("reservation_date")
    @NotNull
    private LocalDate reservationDate;
    @JsonProperty("reservation_status")
    @NotNull
    private ReservationStatusEnum reservationStatus;

    public ReservationDTO() {}

    public ReservationDTO(Long id, String customerId, Long packageId, LocalDate reservationDate, ReservationStatusEnum reservationStatus) {
        this.id = id;
        this.customerId = customerId;
        this.packageId = packageId;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
    }

    public @NotNull Long getId() {
        return id;
    }

    public void setId(@NotNull Long id) {
        this.id = id;
    }

    public @NotBlank String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(@NotBlank String customerId) {
        this.customerId = customerId;
    }

    public @NotNull Long getPackageId() {
        return packageId;
    }

    public void setPackageId(@NotNull Long packageId) {
        this.packageId = packageId;
    }

    public @NotNull LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(@NotNull LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public @NotNull ReservationStatusEnum getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(@NotNull ReservationStatusEnum reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
