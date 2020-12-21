package com.test.demo.controller;


import com.test.demo.endpoint.CarActionEndpoint;
import com.test.demo.endpoint.CheckFreePlaceEndpoint;
import com.test.demo.endpoint.GetListCarEndpoint;
import com.test.demo.exception.NotFoundException;
import com.test.demo.http.dto.AddCarRequestDto;
import com.test.demo.http.dto.CarDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/barrier")
public class MainController {

    private final CheckFreePlaceEndpoint checkFreePlaceEndpoint;
    private final GetListCarEndpoint getListCarEndpoint;
    private final CarActionEndpoint carActionEndpoint;

    public MainController(CheckFreePlaceEndpoint checkFreePlaceEndpoint, GetListCarEndpoint getListCarEndpoint, CarActionEndpoint carActionEndpoint) {
        this.checkFreePlaceEndpoint = checkFreePlaceEndpoint;
        this.getListCarEndpoint = getListCarEndpoint;
        this.carActionEndpoint = carActionEndpoint;
    }

    @PostMapping()
    public CarDto addCar(@RequestBody AddCarRequestDto requestDto) throws NotFoundException{
        return carActionEndpoint.addCar(requestDto);
    }

    @PostMapping("/checking")
    public Boolean haveFreePlace() throws NotFoundException {
        return checkFreePlaceEndpoint.checkFreePlace();
    }

    @GetMapping("/get-list")
    public List<CarDto> getListCar() throws NotFoundException {
        return getListCarEndpoint.getListCar();
    }

    @GetMapping("/get-free-place")
    public Long getFreePlace() throws NotFoundException{
        return checkFreePlaceEndpoint.getFreePlace();
    }

    @PostMapping("/{id}/clean-place")
    public CarDto cleanPlace(@PathVariable Long id) throws NotFoundException {
        return carActionEndpoint.cleanPlace(id);
    }
}
