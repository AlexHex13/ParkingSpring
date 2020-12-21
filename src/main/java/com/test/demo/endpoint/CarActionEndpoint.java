package com.test.demo.endpoint;

import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.AddCarRequestDto;
import com.test.demo.http.dto.CarDto;

public interface CarActionEndpoint {
    CarDto addCar(AddCarRequestDto requestDto) throws NotFoundException;
    CarDto cleanPlace(Long id)throws NotFoundException;
}
