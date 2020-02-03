package com.manjeshk.app.tdd.repository;

import com.manjeshk.app.tdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class CarRepositoryTest {

//    @Autowired
//    private CarRepository repository;
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Test
//    public void findByName() {
//        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
//        Car car = repository.findByName("prius");
//        Assertions.assertThat(car.getName()).isEqualTo("prius");
//        Assertions.assertThat(car.getType()).isEqualTo("hybrid");
//    }

}