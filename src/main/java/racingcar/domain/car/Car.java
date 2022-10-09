package racingcar.domain.car;

import racingcar.domain.random.RandomNumber;

public class Car {

    private static final int MOVING_MIN_NUMBER = 4;
    private final CarName name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new Position(position);
    }

    public CarName getName() {
        return this.name;
    }

    public void move(RandomNumber number) {
        if(number.isMoreThan(MOVING_MIN_NUMBER)) {
            this.position.increase();
        }
    }

    public Position getPosition() {
        return this.position;
    }
}
