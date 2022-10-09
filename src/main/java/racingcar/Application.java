package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.ConsoleController;
import racingcar.controller.GameController;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView gameView = createGameView();
        gameView.render();
    }

    private static GameView createGameView() {
        ConsoleController consoleController = new ConsoleController();
        CarController carController = new CarController();
        GameController gameController = new GameController(new RandomNumberGenerator());
        return new GameView(consoleController, carController, gameController);
    }
}
