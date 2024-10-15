package com.utcn.SCDProiect.pkg;

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
}
