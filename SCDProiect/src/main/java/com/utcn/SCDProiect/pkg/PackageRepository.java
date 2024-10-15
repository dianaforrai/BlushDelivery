package com.utcn.SCDProiect.pkg;

import com.utcn.SCDProiect.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository  extends JpaRepository<Package, Integer> {
    List<Package> findByCourier(Courier courier);
}
