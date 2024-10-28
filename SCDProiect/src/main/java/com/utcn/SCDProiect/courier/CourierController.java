package com.utcn.SCDProiect.courier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/package")
@CrossOrigin
public class CourierController {

    @Autowired
    private CourierService courierService;

    @PostMapping
    public Courier createCourier(Courier courier){
        return courierService.createCourier(courier);
    }
    @GetMapping
    public List<Courier> getAllCouriers(){
        return courierService.getAllCouriers();
    }
    @GetMapping("/available")
    public List<Courier> getAllCouriersWithoutPendingPackages() {
        return courierService.getAllCouriersWithoutPendingPackages();
    }
    @GetMapping("/info")
    public List<Object[]> getAllManagersAndDeliveredNumber() {
        return courierService.getAllManagersAndDeliveredNumber();
    }
}
