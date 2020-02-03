package com.manjeshk.app.tdd.service;

import com.manjeshk.app.tdd.domain.Car;
import com.manjeshk.app.tdd.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    private CarService carService;

    @Before
    public void setUp() {
        //carService = new CarService(carRepository);
    }

    @Test
    public void getCarDetails() {
        given(carRepository.findByName("prius")).willReturn(new Car("prius", "hybrid"));
        //Car car = carService.getCarDetails("prius");

//        Assertions.assertThat(car.getName()).isEqualTo("prius");
//        Assertions.assertThat(car.getType()).isEqualTo("hybrid");
    }
}