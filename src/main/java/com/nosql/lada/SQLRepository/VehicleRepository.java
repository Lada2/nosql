package com.nosql.lada.SQLRepository;


import com.nosql.lada.SQLEntity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findFirstByName(String name);
}
