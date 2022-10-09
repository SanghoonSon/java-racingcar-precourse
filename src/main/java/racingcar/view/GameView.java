package racingcar.view;

import racingcar.controller.CarController;
import racingcar.controller.ConsoleController;
import racingcar.controller.GameController;
import racingcar.domain.car.Cars;
import racingcar.domain.game.GameReport;

import java.util.List;

public class GameView {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final ConsoleController consoleController;
    private final CarController carController;
    private final GameController gameController;

    public GameView(ConsoleController consoleController,
                    CarController carController,
                    GameController gameController) {
        this.consoleController = consoleController;
        this.carController = carController;
        this.gameController = gameController;
    }

    public void render() {
        Cars cars = createCars();
        int gameRounds = inputGameRounds();

        GameReport gameReport = gameController.play(gameRounds, cars);
        consoleController.outputGameReport(gameReport);
    }

    private Cars createCars() {
        List<String> inputCarNames = consoleController.inputCarNames();
        try {
            return carController.createCars(inputCarNames);
        } catch (IllegalArgumentException e) {
            handleError(e);
            return createCars();
        }
    }

    private int inputGameRounds() {
        try {
            return consoleController.inputGameRounds();
        } catch (IllegalArgumentException e) {
            handleError(e);
            return inputGameRounds();
        }
    }

    private void handleError(Throwable e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
