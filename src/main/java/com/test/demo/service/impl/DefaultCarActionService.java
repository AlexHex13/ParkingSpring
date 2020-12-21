package com.test.demo.service.impl;

import com.test.demo.domain.AddCarRequest;
import com.test.demo.domain.Car;
import com.test.demo.exception.NotFoundException;
import com.test.demo.repository.CarActionRepository;
import com.test.demo.repository.CarCountRepository;
import com.test.demo.service.CarActionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DefaultCarActionService implements CarActionService {

    private final CarActionRepository actionRepository;
    private final CarCountRepository carCountRepository;

    public DefaultCarActionService(CarActionRepository actionRepository, CarCountRepository carCountRepository) {
        this.actionRepository = actionRepository;
        this.carCountRepository = carCountRepository;
    }

    @Override
    @Transactional
    public Car add(AddCarRequest carRequest) throws NotFoundException {

        Car car = new Car();
        car.setNameCar(carRequest.getNameCar());
        car.setNumberCar(carRequest.getNumberCar());
        if (carCountRepository.findAll().stream().count() < 5) {
            return actionRepository.save(car);
        }
        return null;
    }

    @Override
    @Transactional
    public Car clean(Long id) throws NotFoundException {
        return actionRepository.deleteCarById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Car find(Long id) throws NotFoundException {
        return actionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Car.class, id, "id"));
    }
}
