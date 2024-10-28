package com.utcn.SCDProiect.pkg;

import com.utcn.SCDProiect.courier.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;

    //CRUD : READ
    public List<Package> getAllPackages() {
        return packageRepository.findAll();
    }

    @Transactional
    //CRUD : CREATE
    public Package createPackage(Package pkg) {
        return packageRepository.save(pkg);
    }

    @Transactional
    public Package modifyPackageDetails(Integer packageId, Package newPackageData) {
        Optional<Package> packageFound = packageRepository.findById(packageId);

        if (!packageFound.isPresent()) {
           return new Package();
        }

        Package currentPackage = packageFound.get();
        currentPackage.setCourier(newPackageData.getCourier());
        currentPackage.setDeliveryAddress(newPackageData.getDeliveryAddress());
        currentPackage.setPayOnDelivery(newPackageData.isPayOnDelivery());
        currentPackage.setStatus(newPackageData.getStatus());

        try {
            return packageRepository.save(currentPackage);
        } catch (Exception exception) {
            System.err.println("Error updating package: " + exception.getMessage());
            return new Package();
        }
    }


    public boolean removePackage(Integer packageId) {
        boolean isDeleted = false;

        try {
            if (packageRepository.findById(packageId).isPresent()) {
                packageRepository.deleteById(packageId);
                isDeleted = true;
            }
        } catch (Exception exception) {
            System.err.println("Failed to delete package: " + exception.getMessage());
        }

        return isDeleted;
    }


    //TODO : chestiile din readme



public List<Package> getPackagesForCourier(Courier courier){
        return packageRepository.findByCourier(courier);
}
}

