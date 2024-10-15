package com.utcn.SCDProiect.pkg;

import com.utcn.SCDProiect.courier.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //TODO : UPDATE
    //TODO : DELETE
    //TODO : chestiile din readme



public List<Package> getPackagesForCourier(Courier courier){
        return packageRepository.findByCourier(courier);
}
}

