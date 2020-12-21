package com.test.demo.mapper.impl;

import com.test.demo.domain.AddCarRequest;
import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.AddCarRequestDto;
import com.test.demo.http.dto.CarDto;
import com.test.demo.mapper.CarMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultCarMapper implements CarMapper {




    @Override
    public CarDto toCarDto(Car car) throws NotFoundException {
        return CarDto.builder()
                .nameCar(car.getNameCar())
                .numberCar(car.getNumberCar())
                .build();
    }

    @Override
    public AddCarRequest toAddCarRequest(AddCarRequestDto requestDto) throws NotFoundException {
        return AddCarRequest.builder()
                .nameCar(requestDto.getNameCar())
                .numberCar(requestDto.getNumberCar())
                .build();
    }
}
