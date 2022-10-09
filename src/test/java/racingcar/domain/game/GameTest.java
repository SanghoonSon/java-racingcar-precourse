package racingcar.domain.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.random.RandomNumber;
import racingcar.domain.random.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("RacingGame 클래스")
class GameTest {

    @Mock
    private static RandomNumberGenerator randomNumberGenerator;

    @BeforeAll
    static void setUp() {
        randomNumberGenerator = mockRandomNumberGenerator(Arrays.asList(1, 5, 3, 1));
    }

    private static RandomNumberGenerator mockRandomNumberGenerator(final List<Integer> randomNumbers) {
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.create()).thenAnswer(new Answer<RandomNumber>() {
            int randomNumberSeq = 0;
            @Override
            public RandomNumber answer(InvocationOnMock invocation) {
                return new RandomNumber(randomNumbers.get(randomNumberSeq++));
            }
        });
        return randomNumberGenerator;
    }

    @Test
    @DisplayName("자동차 경주 게임을 시작하고 경주 결과를 리턴한다.")
    void play_game_and_report_return_test() {
        // given
        Cars cars = createCars();
        Game game = new Game(randomNumberGenerator);

        // when
        GameReport gameReport = game.play(1, cars);
        List<RoundReport> roundReports = gameReport.getRoundReports();
        String printContents = roundReports.get(0).print();
        List<String> winners = gameReport.getWinners().getCarNameValues();

        // then
        assertThat(printContents).contains("test1 : \n")
                .contains("test2 : -\n")
                .contains("test3 : \n")
                .contains("test4 : \n");
        assertEquals("최종 우승자 : test2", "최종 우승자 : " + String.join(",", winners));
    }

    private Cars createCars() {
        return Cars.asList(
                new Car("test1", 0),
                new Car("test2", 0),
                new Car("test3", 0),
                new Car("test4", 0)
        );
    }
}