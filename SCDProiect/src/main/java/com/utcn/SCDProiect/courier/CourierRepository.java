package com.utcn.SCDProiect.courier;

import com.utcn.SCDProiect.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierRepository  extends JpaRepository<Courier, Integer> {
    List<Courier> findByCourier(Courier courier);
}
