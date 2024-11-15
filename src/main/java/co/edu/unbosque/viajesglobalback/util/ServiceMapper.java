package co.edu.unbosque.viajesglobalback.util;

import co.edu.unbosque.viajesglobalback.model.dto.*;
import co.edu.unbosque.viajesglobalback.model.entity.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ServiceMapper {
    public static FlightDTO toFlightDTO(Flight entity) {
        try {
            return new FlightDTO(
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getAvailability(),
                    entity.getFlightNumber(),
                    entity.getAirline(),
                    entity.getOrigin(),
                    entity.getDestination(),
                    entity.getDepartureDate(),
                    entity.getArrivalDate(),
                    entity.getFlightClass()
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Flight to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Flight toFlightEntity(FlightDTO dto) {
        try {
            Flight flight = new Flight();
            flight.setName(dto.getName());
            flight.setDescription(dto.getDescription());
            flight.setAvailability(dto.getAvailability());
            flight.setPrice(dto.getPrice());
            flight.setFlightNumber(dto.getFlightNumber());
            flight.setAirline(dto.getAirline());
            flight.setOrigin(dto.getOrigin());
            flight.setDestination(dto.getDestination());
            flight.setDepartureDate(dto.getDepartureDate());
            flight.setArrivalDate(dto.getArrivalDate());
            flight.setFlightClass(dto.getFlightClass());
            return flight;
        } catch (Exception e) {
            System.err.println("Error Mapping Flight to Entity!");
            e.printStackTrace();
            return null;
        }
    }

    public static HotelDTO toHotelDTO(Hotel entity) {
        String additionalServices = entity.getAdditionalServices();
        Set<String> additionalServicesSet = additionalServices != null ? Arrays.stream(additionalServices.split(",")).collect(Collectors.toSet())  : Set.of();
        try {
            return new HotelDTO(
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getAvailability(),
                    entity.getHotelName(),
                    entity.getLocation(),
                    entity.getStars(),
                    entity.getRoomType(),
                    additionalServicesSet
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Hotel to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Hotel toHotelEntity(HotelDTO dto) {
        try {
            Hotel hotel = new Hotel();
            hotel.setName(dto.getName());
            hotel.setDescription(dto.getDescription());
            hotel.setAvailability(dto.getAvailability());
            hotel.setPrice(dto.getPrice());
            hotel.setHotelName(dto.getHotelName());
            hotel.setLocation(dto.getLocation());
            hotel.setStars(dto.getStars());
            hotel.setRoomType(dto.getRoomType());
            String additionalServices = dto.getAdditionalServices().toString().replaceAll(" ", "");
            hotel.setAdditionalServices(additionalServices.substring(1, additionalServices.length() - 1));
            return hotel;
        } catch (Exception e) {
            System.err.println("Error Mapping Hotel to Entity!");
            e.printStackTrace();
            return null;
        }
    }

    public static ExcursionDTO toExcursionDTO(Excursion entity) {
        try {
            return new ExcursionDTO(
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getAvailability(),
                    entity.getDuration()
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Excursion to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Excursion toExcursionEntity(ExcursionDTO dto) {
        try {
            Excursion excursion = new Excursion();
            excursion.setName(dto.getName());
            excursion.setDescription(dto.getDescription());
            excursion.setPrice(dto.getPrice());
            excursion.setAvailability(dto.getAvailability());
            excursion.setDuration(dto.getDuration());
            return excursion;
        } catch (Exception e) {
            System.err.println("Error Mapping Excursion to Entity!");
            e.printStackTrace();
            return null;
        }
    }

    public static TransportDTO toTransportDTO(Transport entity) {
        try {
            return new TransportDTO(
                    entity.getName(),
                    entity.getDescription(),
                    entity.getPrice(),
                    entity.getAvailability(),
                    entity.getTransportType(),
                    entity.getOrigin(),
                    entity.getDestination()
            );
        } catch (Exception e) {
            System.err.println("Error Mapping Transport to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Transport toTransportEntity(TransportDTO dto) {
        try {
            Transport transport = new Transport();
            transport.setName(dto.getName());
            transport.setDescription(dto.getDescription());
            transport.setPrice(dto.getPrice());
            transport.setAvailability(dto.getAvailability());
            transport.setTransportType(dto.getTransportType());
            transport.setOrigin(dto.getOrigin());
            transport.setDestination(dto.getDestination());
            return transport;
        } catch (Exception e) {
            System.err.println("Error Mapping Transport to Entity!");
            e.printStackTrace();
            return null;
        }
    }
}
