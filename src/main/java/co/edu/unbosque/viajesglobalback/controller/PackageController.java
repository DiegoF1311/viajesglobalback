package co.edu.unbosque.viajesglobalback.controller;

import co.edu.unbosque.viajesglobalback.model.dto.PackageDTO;
import co.edu.unbosque.viajesglobalback.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Transactional
@CrossOrigin(origins = "*")
public class PackageController {
    @Autowired
    public PackageService packageService;

    @PostMapping("/package/createPackage")
    public ResponseEntity<String> createPackage(@Valid @RequestBody PackageDTO packageDTO) {
        try {
            packageService.createPackage(packageDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("BAD REQUEST");
        }
    }

    @GetMapping("/package/getPackageInfo")
    public ResponseEntity<PackageDTO> getPackageInfo(@RequestParam Long id) {
        PackageDTO pkg = packageService.getPackageInfo(id);
        if (pkg == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(pkg);
    }

    @GetMapping("/package/getAllPackages")
    public ResponseEntity<Set<PackageDTO>> getAllPackages() {
        Set<PackageDTO> packages = packageService.getAllPackages();
        if (packages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.ok(packages);
    }
}
