package com.test.demo.service.impl;


import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;
import com.test.demo.repository.CarCountRepository;
import com.test.demo.service.CarCountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCarCountService implements CarCountService {

    private final CarCountRepository carCountRepository;


    public DefaultCarCountService(CarCountRepository carCountRepository) {
        this.carCountRepository = carCountRepository;
    }

    @Override
    public List<Car> getListCar() throws NotFoundException {
        return carCountRepository.findAll();
    }

}
