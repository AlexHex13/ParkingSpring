package com.test.demo.mapper;

import com.test.demo.domain.AddCarRequest;
import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.AddCarRequestDto;
import com.test.demo.http.dto.CarDto;

public interface CarMapper {
    CarDto toCarDto(Car car) throws NotFoundException;
    AddCarRequest toAddCarRequest(AddCarRequestDto requestDto) throws NotFoundException;
}
