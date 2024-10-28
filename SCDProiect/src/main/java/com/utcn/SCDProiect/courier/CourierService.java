package com.utcn.SCDProiect.courier;

import com.utcn.SCDProiect.courier.Courier;
import com.utcn.SCDProiect.pkg.Package;
import com.utcn.SCDProiect.pkg.PackageRepository;
import com.utcn.SCDProiect.pkg.PackageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourierService {
    private CourierRepository courierRepository;

    //CRUD : READ
    public List<Courier> getAllCouriers() {
        return courierRepository.findAll();
    }

    @Transactional
    //CRUD : CREATE
    public Courier createCourier(Courier courier) {
        return courierRepository.save(courier);
    }


    @Transactional
    public Courier modifyCourierDetails(Integer courierId, Courier newCourierData) {
        Optional<Courier> courierRecord = courierRepository.findById(courierId);

        if (courierRecord.isEmpty()) {
            return new Courier();
        }

        Courier existingCourier = courierRecord.get();
        existingCourier.setName(newCourierData.getName());
        existingCourier.setEmail(newCourierData.getEmail());
        existingCourier.setManager(newCourierData.getManager());

        try {
            return courierRepository.save(existingCourier);
        } catch (Exception exception) {
            System.err.println("Failed to update courier: " + exception.getMessage());
            return new Courier();
        }
    }
    @Transactional
    public boolean removeCourier(Integer id) {
        boolean isDeleted = false;

        try {
            Optional<Courier> courierToRemove = courierRepository.findById(id);

            if (courierToRemove.isPresent()) {
                courierRepository.delete(courierToRemove.get());
                isDeleted = true;
            }
        } catch (RuntimeException ex) {
            System.err.println("Error deleting courier: " + ex.getMessage());
        }

        return isDeleted;
    }

    public List<Courier> getAllCouriersWithoutPendingPackages() {
        return courierRepository.findAllCouriersWithoutPendingPackages(PackageStatus.PENDING);
    }

    public List<Object[]> getAllManagersAndDeliveredNumber() {
        return courierRepository.findAllManagersAndDeliveredNumber(PackageStatus.DELIVERED);
    }
}

