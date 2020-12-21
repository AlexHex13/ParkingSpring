package com.test.demo.endpoint.impl;

import com.test.demo.domain.Car;
import com.test.demo.endpoint.GetListCarEndpoint;
import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.CarDto;
import com.test.demo.mapper.CarMapper;
import com.test.demo.service.CarCountService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetListCarEndpointImpl implements GetListCarEndpoint {

    private final CarCountService carCountService;
    private final CarMapper carMapper;

    public GetListCarEndpointImpl(CarCountService carCountService, CarMapper carMapper) {
        this.carCountService = carCountService;
        this.carMapper = carMapper;
    }

    @Override
    public List<CarDto> getListCar() throws NotFoundException {
        List<Car> cars = carCountService.getListCar();
        List<CarDto> carDtos = new ArrayList<>();

        for( Car car : cars){
            carDtos.add(carMapper.toCarDto(car));
        }
        return carDtos;
    }
}
