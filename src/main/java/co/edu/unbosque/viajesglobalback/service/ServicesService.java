package co.edu.unbosque.viajesglobalback.service;

import co.edu.unbosque.viajesglobalback.model.dto.*;
import co.edu.unbosque.viajesglobalback.model.entity.Excursion;
import co.edu.unbosque.viajesglobalback.model.entity.Flight;
import co.edu.unbosque.viajesglobalback.model.entity.Hotel;
import co.edu.unbosque.viajesglobalback.model.entity.Transport;
import co.edu.unbosque.viajesglobalback.repository.*;
import co.edu.unbosque.viajesglobalback.util.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ServicesService {
    @Autowired
    public ServiceRepository serviceRepository;

    @Autowired
    public FlightRepository flightRepository;

    @Autowired
    public HotelRepository hotelRepository;

    @Autowired
    public ExcursionRepository excursionRepository;

    @Autowired
    public TransportRepository transportRepository;

    public void createFlight(FlightDTO dto) {
        flightRepository.save(Objects.requireNonNull(ServiceMapper.toFlightEntity(dto)));
    }

    public void createHotel(HotelDTO dto) {
        hotelRepository.save(Objects.requireNonNull(ServiceMapper.toHotelEntity(dto)));
    }

    public void createExcursion(ExcursionDTO dto) {
        excursionRepository.save(Objects.requireNonNull(ServiceMapper.toExcursionEntity(dto)));
    }

    public void createTransport(TransportDTO dto) {
        transportRepository.save(Objects.requireNonNull(ServiceMapper.toTransportEntity(dto)));
    }

    public List<ServiceDTO> getAllServices() {
        List<ServiceDTO> services = new ArrayList<>();
        serviceRepository.findAll().forEach(service -> {
            if (service instanceof Flight) {
                services.add(ServiceMapper.toFlightDTO((Flight) service));
            } else if (service instanceof Hotel) {
                services.add(ServiceMapper.toHotelDTO((Hotel) service));
            } else if (service instanceof Excursion) {
                services.add(ServiceMapper.toExcursionDTO((Excursion) service));
            } else if (service instanceof Transport) {
                services.add(ServiceMapper.toTransportDTO((Transport) service));
            }
        });
        return services;
    }

    public List<FlightDTO> getAllFlights() {
        List<FlightDTO> flights = new ArrayList<>();
        flightRepository.findAll().forEach(flight -> flights.add(ServiceMapper.toFlightDTO(flight)));
        return flights;
    }

    public List<HotelDTO> getAllHotels() {
        List<HotelDTO> hotels = new ArrayList<>();
        hotelRepository.findAll().forEach(hotel -> hotels.add(ServiceMapper.toHotelDTO(hotel)));
        return hotels;
    }

    public List<ExcursionDTO> getAllExcursions() {
        List<ExcursionDTO> excursions = new ArrayList<>();
        excursionRepository.findAll().forEach(excursion -> excursions.add(ServiceMapper.toExcursionDTO(excursion)));
        return excursions;
    }

    public List<TransportDTO> getAllTransports() {
        List<TransportDTO> transports = new ArrayList<>();
        transportRepository.findAll().forEach(transport -> transports.add(ServiceMapper.toTransportDTO(transport)));
        return transports;
    }
}
