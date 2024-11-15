package co.edu.unbosque.viajesglobalback.model.dto;

import co.edu.unbosque.viajesglobalback.model.enums.FlightClassEnum;
import co.edu.unbosque.viajesglobalback.model.enums.RoomTypeEnum;
import co.edu.unbosque.viajesglobalback.model.enums.TransportTypeEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class ServiceDTOFactory {
    public static FlightDTO createFlightDTO(String name, String description, Float price, Integer availability, String flightNumber, String airline, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, FlightClassEnum flightClass) {
        return new FlightDTO(name, description, price, availability, flightNumber, airline, origin, destination, departureDate, arrivalDate, flightClass);
    }

    public static ExcursionDTO createExcursionDTO(String name, String description, Float price, Integer availability, Integer duration) {
        return new ExcursionDTO(name, description, price, availability, duration);
    }

    public static HotelDTO createHotelDTO(String name, String description, Float price, Integer availability, String hotelName, String location, Integer stars, RoomTypeEnum roomType, Set<String> additionalServices) {
        return new HotelDTO(name, description, price, availability, hotelName, location, stars, roomType, additionalServices);
    }

    public static TransportDTO createTransportDTO(String name, String description, Float price, Integer availability, TransportTypeEnum transportType, String origin, String destination) {
        return new TransportDTO(name, description, price, availability, transportType, origin, destination);
    }
}
