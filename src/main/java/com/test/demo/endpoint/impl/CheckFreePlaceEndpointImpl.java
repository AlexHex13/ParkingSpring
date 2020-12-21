package com.test.demo.endpoint.impl;


import com.test.demo.endpoint.CheckFreePlaceEndpoint;
import com.test.demo.exception.NotFoundException;
import com.test.demo.service.CarCountService;
import org.springframework.stereotype.Service;

@Service
public class CheckFreePlaceEndpointImpl implements CheckFreePlaceEndpoint{
    private final Integer freeCount = 5;
    private final CarCountService carCountService;

    public CheckFreePlaceEndpointImpl(CarCountService carCountService) {
        this.carCountService = carCountService;
    }

    @Override
    public Boolean checkFreePlace() throws NotFoundException {
        return carCountService.getListCar().stream().count() <freeCount;
    }

    @Override
    public Long getFreePlace() throws NotFoundException {
        return freeCount - carCountService.getListCar().stream().count();
    }
}
