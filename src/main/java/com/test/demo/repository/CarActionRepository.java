package com.test.demo.repository;

import com.test.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarActionRepository extends JpaRepository<Car,Long> {
        Car deleteCarById(Long id);
}
