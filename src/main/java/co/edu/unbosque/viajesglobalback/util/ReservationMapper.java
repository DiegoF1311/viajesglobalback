package co.edu.unbosque.viajesglobalback.util;

import co.edu.unbosque.viajesglobalback.model.dto.ReservationDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Reservation;

public class ReservationMapper {
    public static ReservationDTO toDTO(Reservation entity) {
        try {
            return new ReservationDTO(
                    entity.getReservationId(),
                    entity.getCustomer().getCustomerId(),
                    entity.getTravelPackage().getPackageId(),
                    entity.getReservationDate(),
                    entity.getStatus()
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Reservation to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Reservation toEntity(ReservationDTO dto) {
        try {
            Reservation reservation = new Reservation();
            reservation.setReservationDate(dto.getReservationDate());
            reservation.setStatus(dto.getReservationStatus());
            return reservation;
        } catch (Exception e) {
            System.err.println("Error Mapping Reservation to Entity!");
            e.printStackTrace();
            return null;
        }
    }
}
