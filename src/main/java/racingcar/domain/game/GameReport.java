package racingcar.domain.game;

import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameReport {
    private final List<RoundReport> roundReports;

    public GameReport() {
        this.roundReports = new ArrayList<>();
    }

    public void addRoundReport(RoundReport report) {
        this.roundReports.add(report);
    }

    public List<RoundReport> getRoundReports() {
        return Collections.unmodifiableList(this.roundReports);
    }

    public Cars getWinners() {
        return getFinalRoundReport().getWinners();
    }

    private RoundReport getFinalRoundReport() {
        return this.roundReports.get(this.roundReports.size() - 1);
    }

}
