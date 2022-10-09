package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.random.RandomNumberGenerator;

public class Game {

    private final RandomNumberGenerator randomNumberGenerator;

    public Game(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public GameReport play(int rounds, Cars cars) {
        GameReport gameReport = new GameReport();
        for(int i=0; i < rounds; i++) {
            gameReport.addRoundReport(playRound(cars));
        }
        return gameReport;
    }

    private RoundReport playRound(Cars cars) {
        cars.move(randomNumberGenerator);
        return new RoundReport(cars);
    }
}
