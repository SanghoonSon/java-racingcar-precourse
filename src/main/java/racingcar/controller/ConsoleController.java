package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.game.GameReport;
import racingcar.domain.game.RoundReport;
import racingcar.global.ConsoleConst;
import racingcar.global.Patterns;

import java.util.Arrays;
import java.util.List;

public class ConsoleController {

    public List<String> inputCarNames() {
        System.out.println(ConsoleConst.INPUT_CAR_NAMES.getContents());
        String inputCarNames = Console.readLine();
        return Arrays.asList(inputCarNames.split(","));
    }

    public int inputGameRounds() {
        System.out.println(ConsoleConst.INPUT_GAME_ROUNDS.getContents());
        String inputGameRounds = Console.readLine();
        validateInputGameRounds(inputGameRounds);
        return Integer.parseInt(inputGameRounds);
    }

    private void validateInputGameRounds(String inputGameRounds) {
        if(!Patterns.ONLY_NUMBER.matches(inputGameRounds)) {
            throw new IllegalArgumentException(ConsoleConst.ERROR_GAME_ROUNDS_NOT_NUMBERS.getContents());
        }
    }

    public void outputGameReport(GameReport gameReport) {
        System.out.println();
        System.out.println(ConsoleConst.OUTPUT_GAME_REPORT.getContents());
        for (RoundReport roundReport : gameReport.getRoundReports()) {
            System.out.println(roundReport.print());
        }
        List<String> carNameValues = gameReport.getWinners().getCarNameValues();
        System.out.println(ConsoleConst.OUTPUT_WINNERS.getContentsFormat(String.join(", ", carNameValues)));
    }
}
