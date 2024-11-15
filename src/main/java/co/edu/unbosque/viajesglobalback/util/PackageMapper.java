package co.edu.unbosque.viajesglobalback.util;

import co.edu.unbosque.viajesglobalback.model.dto.PackageDTO;
import co.edu.unbosque.viajesglobalback.model.entity.Package;

import java.util.HashSet;
import java.util.Set;

public class PackageMapper {
    public static PackageDTO toDto(Package entity) {
        try {
            Set<Long> servicesId = new HashSet<>();
            entity.getServices().forEach(service -> {
                servicesId.add(service.getServiceId());
            });
            return new PackageDTO.PackageDTOBuilder()
                    .setPackageName(entity.getPackageName())
                    .setDescription(entity.getDescription())
                    .setTotalPrice(entity.getTotalPrice())
                    .setStartDate(entity.getStartDate())
                    .setEndDate(entity.getEndDate())
                    .setAvailability(entity.getAvailability())
                    .setServices(servicesId)
                    .build();

        } catch (Exception e) {
            System.err.println("Error Mapping Package to DTO!");
            e.printStackTrace();
            return null;
        }
    }

    public static Package toEntity(PackageDTO dto) {
        try {
            Package pkg = new Package();
            pkg.setPackageName(dto.getPackageName());
            pkg.setDescription(dto.getDescription());
            pkg.setTotalPrice(dto.getTotalPrice());
            pkg.setStartDate(dto.getStartDate());
            pkg.setEndDate(dto.getEndDate());
            pkg.setAvailability(dto.getAvailability());
            return pkg;
        } catch (Exception e) {
            System.err.println("Error Mapping Package to Entity!");
            e.printStackTrace();
            return null;
        }
    }
}
