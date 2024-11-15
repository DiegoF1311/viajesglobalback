package co.edu.unbosque.viajesglobalback.controller;

import co.edu.unbosque.viajesglobalback.model.dto.*;
import co.edu.unbosque.viajesglobalback.service.ServicesService;
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
public class ServiceController {
    @Autowired
    public ServicesService servicesService;

    @PostMapping("/service/createFlight")
    public ResponseEntity<String> createFlight(@Valid @RequestBody FlightDTO flightDTO) {
        try {
            servicesService.createFlight(flightDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        }
    }

    @PostMapping("/service/createHotel")
    public ResponseEntity<String> createHotel(@Valid @RequestBody HotelDTO hotelDTO) {
        try {
            servicesService.createHotel(hotelDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        }
    }

    @PostMapping("/services/createExcursion")
    public ResponseEntity<String> createExcursion(@Valid @RequestBody ExcursionDTO excursionDTO) {
        try {
            servicesService.createExcursion(excursionDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        }
    }

    @PostMapping("/services/createTransport")
    public ResponseEntity<String> createTransport(@Valid @RequestBody TransportDTO transportDTO) {
        try {
            servicesService.createTransport(transportDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        }
    }

    @GetMapping("/services/getAllServices")
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        List<ServiceDTO> services = servicesService.getAllServices();
        if (services.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(services);
    }

    @GetMapping("/services/getAllFlights")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<FlightDTO> flights = servicesService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/services/getAllHotels")
    public ResponseEntity<List<HotelDTO>> getAllHotels() {
        List<HotelDTO> hotels = servicesService.getAllHotels();
        if (hotels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/services/getAllExcursions")
    public ResponseEntity<List<ExcursionDTO>> getAllExcursions() {
        List<ExcursionDTO> excursions = servicesService.getAllExcursions();
        if (excursions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(excursions);
    }

    @GetMapping("/services/getAllTransports")
    public ResponseEntity<List<TransportDTO>> getAllTransports() {
        List<TransportDTO> transports = servicesService.getAllTransports();
        if (transports.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(transports);
    }
}
