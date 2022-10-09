package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.domain.game.Game;
import racingcar.domain.game.GameReport;
import racingcar.domain.random.RandomNumberGenerator;

public class GameController {

    private final RandomNumberGenerator randomNumberGenerator;

    public GameController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public GameReport play(int rounds, Cars cars) {
        Game game = new Game(randomNumberGenerator);
        return game.play(rounds, cars);
    }
}
