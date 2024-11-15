package co.edu.unbosque.viajesglobalback.controller;

import co.edu.unbosque.viajesglobalback.model.dto.ReservationDTO;
import co.edu.unbosque.viajesglobalback.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation/create")
    public ResponseEntity<String> createReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        try {
            boolean flag = reservationService.createReservation(reservationDTO);
            if (flag) {
                return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR CREATING RESERVATION");
        }
    }

    @GetMapping("/reservation/getReservationsByCustomer")
    public ResponseEntity<List<ReservationDTO>> getReservationsByCustomer(@RequestParam String customerId) {
        try {
            List<ReservationDTO> reservations = reservationService.getReservationsByCustomer(customerId);
            return ResponseEntity.status(HttpStatus.OK).body(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/reservation/getAllReservations")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        try {
            List<ReservationDTO> reservations = reservationService.getAllReservations();
            return ResponseEntity.status(HttpStatus.OK).body(reservations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
