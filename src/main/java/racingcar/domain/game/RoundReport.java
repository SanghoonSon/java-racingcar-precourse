package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RoundReport {

    private final Cars winners;
    private final StringBuilder printer;

    public RoundReport(Cars cars) {
        this.winners = cars.getMostMovedCars();
        this.printer = createPrinter(cars);
    }

    private StringBuilder createPrinter(Cars cars) {
        StringBuilder printer = new StringBuilder();
        for (Car car : cars.getCars()) {
            printer.append(car.getName().value())
                    .append(" : ")
                    .append(car.getPosition().report())
                    .append("\n");
        }
        return printer;
    }

    public Cars getWinners() {
        return this.winners;
    }

    public String print() {
        return this.printer.toString();
    }
}
