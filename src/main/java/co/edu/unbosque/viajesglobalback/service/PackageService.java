package co.edu.unbosque.viajesglobalback.service;

import co.edu.unbosque.viajesglobalback.model.dto.PackageDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Package;
import co.edu.unbosque.viajesglobalback.repository.PackageRepository;
import co.edu.unbosque.viajesglobalback.repository.ServiceRepository;
import co.edu.unbosque.viajesglobalback.util.PackageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PackageService {
    @Autowired
    public PackageRepository packageRepository;

    @Autowired
    public ServiceRepository serviceRepository;

    public boolean createPackage(PackageDTO dto) {
        Package pkg = PackageMapper.toEntity(dto);
        Set<co.edu.unbosque.viajesglobalback.model.entity.Service> services = new HashSet<>();
        float totalPrice = 0;
        for (Long serviceId : dto.getServices()) {
            Optional<co.edu.unbosque.viajesglobalback.model.entity.Service> service = serviceRepository.findById(serviceId);
            if (service.isPresent()) {
                services.add(service.get());
                totalPrice += service.get().getPrice();
            }
        }
        if (services.isEmpty()) {
            return false;
        }
        pkg.setServices(services);
        pkg.setTotalPrice(totalPrice);
        packageRepository.save(pkg);
        return true;
    }

    public PackageDTO getPackageInfo(Long id) {
        Optional<Package> pkg = packageRepository.findById(id);
        if (pkg.isPresent()) {
            return PackageMapper.toDto(pkg.get());
        }
        return null;
    }

    public Set<PackageDTO> getAllPackages() {
        Set<PackageDTO> packages = new HashSet<>();
        packageRepository.findAll().forEach(pkg -> packages.add(PackageMapper.toDto(pkg)));
        return packages;
    }
}
