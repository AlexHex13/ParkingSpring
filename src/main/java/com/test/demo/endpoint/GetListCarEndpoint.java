package com.test.demo.endpoint;

import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.CarDto;

import java.util.List;

public interface GetListCarEndpoint {
    List<CarDto> getListCar() throws NotFoundException;
}
