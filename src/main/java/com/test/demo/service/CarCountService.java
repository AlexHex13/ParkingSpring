package com.test.demo.service;

import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;

import java.util.List;

public interface CarCountService {
    List<Car> getListCar() throws NotFoundException;
}
