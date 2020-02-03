package com.manjeshk.app.tdd.contoller;

import com.manjeshk.app.tdd.domain.Car;
import com.manjeshk.app.tdd.exception.CarNotFoundException;
import com.manjeshk.app.tdd.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    private Car getCar(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {
    }


}
