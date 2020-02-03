package com.manjeshk.app.tdd.service;

import com.manjeshk.app.tdd.domain.Car;
import com.manjeshk.app.tdd.exception.CarNotFoundException;
import com.manjeshk.app.tdd.repository.CarRepository;
import org.springframework.stereotype.Service;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = carRepository.findByName(name);
        if(car == null){
            throw new CarNotFoundException();
        }

        return car;
    }
}
