package com.utcn.SCDProiect.courier;

import com.utcn.SCDProiect.courier.Courier;
import com.utcn.SCDProiect.pkg.PackageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourierRepository  extends JpaRepository<Courier, Integer> {
    @Query("SELECT courier FROM Courier courier WHERE courier.id NOT IN (SELECT package.courier.id FROM Package package WHERE package.status = :status)")
    List<Courier> findAllCouriersWithoutPendingPackages(@Param("status") PackageStatus status);

    @Query("SELECT courier.manager.id, COUNT(package) FROM Package package JOIN package.courier courier WHERE package.status = :status GROUP BY courier.manager.id")
    List<Object[]> findAllManagersAndDeliveredNumber(@Param("status") PackageStatus status);
}
