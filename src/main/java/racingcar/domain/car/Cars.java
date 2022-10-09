package racingcar.domain.car;

import racingcar.domain.random.RandomNumber;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.*;
import java.util.function.Function;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNameDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCarNameDuplicate(List<Car> cars) {
        List<CarName> carNames = mapTo(cars, Car::getName);
        HashSet<CarName> carNameHashSet = new HashSet<>(carNames);
        if(carNames.size() != carNameHashSet.size()) {
            throw new IllegalArgumentException("차 이름은 중복될 수 없습니다.");
        }
    }

    private <R> List<R> mapTo(List<Car> cars, Function<Car, R> function) {
        List<R> functionResults = new ArrayList<>();
        for (Car car : cars) {
            functionResults.add(function.apply(car));
        }
        return functionResults;
    }

    public static Cars asList(Car... car) {
        return new Cars(Arrays.asList(car));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<String> getCarNameValues() {
        return mapTo(getCars(), car -> car.getName().value());
    }

    public Cars getMostMovedCars() {
        List<Car> cars = new ArrayList<>(this.cars);
        cars.sort((o1, o2) -> Integer.compare(o1.getPosition().count(), o2.getPosition().count()) * -1);

        List<Car> mostMovedCars = new ArrayList<>();
        for (Car car : cars) {
            addMostMovedCar(mostMovedCars, car);
        }
        return new Cars(mostMovedCars);
    }

    private void addMostMovedCar(List<Car> mostMovedCars, Car car) {
        int maxPosition = mostMovedCars.isEmpty()
                ? 0
                : mostMovedCars.get(0).getPosition().count();
        if(maxPosition > car.getPosition().count()) {
            return;
        }
        mostMovedCars.add(car);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars that = (Cars) o;

        return cars.equals(that.cars);
    }

    @Override
    public int hashCode() {
        return cars.hashCode();
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : getCars()) {
            RandomNumber number = randomNumberGenerator.create();
            car.move(number);
        }
    }
}
