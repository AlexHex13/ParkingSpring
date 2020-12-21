package com.test.demo.service;

import com.test.demo.domain.AddCarRequest;
import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;

public interface CarActionService {
    Car add(AddCarRequest carRequest) throws NotFoundException;
    Car clean(Long id) throws NotFoundException;
    Car find(Long id) throws NotFoundException;
}
