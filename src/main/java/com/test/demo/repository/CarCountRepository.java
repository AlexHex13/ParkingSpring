package com.test.demo.repository;

import com.test.demo.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarCountRepository extends JpaRepository<Car,Long> {
}
