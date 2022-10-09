package racingcar.domain.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Advances 클래스")
class PositionTest {

    @Test
    @DisplayName("전진 횟수를 출력한다")
    void report_advance_counts() {
        // given
        Position position = new Position(0);
        position.increase();
        position.increase();

        // when
        String report = position.report();

        // then
        Assertions.assertEquals("--", report);
    }
}