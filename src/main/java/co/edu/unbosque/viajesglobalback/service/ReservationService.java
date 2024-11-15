package co.edu.unbosque.viajesglobalback.service;

import co.edu.unbosque.viajesglobalback.model.dto.ReservationDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Customer;
import co.edu.unbosque.viajesglobalback.model.entity.Package;
import co.edu.unbosque.viajesglobalback.model.entity.Reservation;
import co.edu.unbosque.viajesglobalback.model.enums.ReservationStatusEnum;
import co.edu.unbosque.viajesglobalback.repository.CustomerRepository;
import co.edu.unbosque.viajesglobalback.repository.PackageRepository;
import co.edu.unbosque.viajesglobalback.repository.ReservationRepository;
import co.edu.unbosque.viajesglobalback.util.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PackageRepository packageRepository;

    public boolean createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.toEntity(reservationDTO);
        Optional<Customer> customer = customerRepository.findById(reservationDTO.getCustomerId());
        Optional<Package> packageOp = packageRepository.findById(reservationDTO.getPackageId());
        if (customer.isPresent() && packageOp.isPresent() && reservation != null) {
            reservation.setCustomer(customer.get());
            reservation.setTravelPackage(packageOp.get());
        } else {
            return false;
        }
        reservationRepository.save(reservation);
        return true;
    }

    public void changeReservationStatus(Long reservationId, String newStatus) {
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        Reservation entity = new Reservation();
        if (reservation.isPresent()) {
            entity = reservation.get();
            entity.setStatus(ReservationStatusEnum.valueOf(newStatus));
            reservationRepository.save(entity);
        }
    }

    public List<ReservationDTO> getReservationsByCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        List<ReservationDTO> dtos = new ArrayList<>();
        if (customer.isPresent()) {
            reservationRepository.findAllByCustomer(customer.get()).forEach(reservation -> dtos.add(ReservationMapper.toDTO(reservation)));
            return dtos;
        }
        return null;
    }

    public List<ReservationDTO> getAllReservations() {
        List<ReservationDTO> dtos = new ArrayList<>();
        reservationRepository.findAll().forEach(entity -> dtos.add(ReservationMapper.toDTO(entity)));
        return dtos;
    }
}
