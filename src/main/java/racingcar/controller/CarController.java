package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private static final int CAR_DEFAULT_POSITION = 0;

    public Cars createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, CAR_DEFAULT_POSITION));
        }
        return new Cars(cars);
    }
}
