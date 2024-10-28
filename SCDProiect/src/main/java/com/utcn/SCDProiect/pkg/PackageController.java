package com.utcn.SCDProiect.pkg;

import com.utcn.SCDProiect.courier.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@CrossOrigin
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping
    public Package createPackage(Package pkg){
        return packageService.createPackage(pkg);
    }
    @GetMapping
    public List<Package> getAllPackages(){
        return packageService.getAllPackages();
    }
    @PutMapping("/{id}")
    public Package updatePackage(@PathVariable Integer id, @RequestBody Package updatedPackage) {
        return packageService.modifyPackageDetails(id, updatedPackage);
    }

    @DeleteMapping("/{id}")
    public boolean deletePackage(@PathVariable Integer id) {
        return packageService.removePackage(id);
    }
    @GetMapping("/courier/{courierId}")
    public List<Package> getPackagesForCourier(@PathVariable Courier courier) {
        return packageService.getPackagesForCourier(courier);
    }

}
