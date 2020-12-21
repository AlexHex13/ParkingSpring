package com.test.demo.endpoint.impl;

import com.test.demo.domain.AddCarRequest;
import com.test.demo.domain.Car;
import com.test.demo.endpoint.CarActionEndpoint;
import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.AddCarRequestDto;
import com.test.demo.http.dto.CarDto;
import com.test.demo.mapper.CarMapper;
import com.test.demo.service.CarActionService;
import org.springframework.stereotype.Service;

@Service
public class CarActionEndpointImpl implements CarActionEndpoint {

    private final CarMapper carMapper;
    private final CarActionService carActionService;

    public CarActionEndpointImpl(CarMapper carMapper, CarActionService carActionService) {
        this.carMapper = carMapper;
        this.carActionService = carActionService;
    }

    @Override
    public CarDto addCar(AddCarRequestDto requestDto) throws NotFoundException {
        AddCarRequest request = carMapper.toAddCarRequest(requestDto);
        Car car = carActionService.add(request);
        return carMapper.toCarDto(car);
    }

    @Override
    public CarDto cleanPlace(Long id) throws NotFoundException {
        CarDto car = carMapper.toCarDto(carActionService.clean(id));
        return car;
    }
}
