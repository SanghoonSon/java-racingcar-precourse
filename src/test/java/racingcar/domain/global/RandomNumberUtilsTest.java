package racingcar.domain.global;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("RandomNumberUtils 클래스")
class RandomNumberUtilsTest {

    @Test
    @DisplayName("0 ~ 9 사이 랜덤값을 리턴")
    void create_random_number_test() {
        // when
        RandomNumber number = RandomNumberUtils.getNumber();

        // then
        assertTrue(number.value() > 0 && number.value() < 10, "0 ~ 9 사이의 랜덤값이어야 합니다.");
    }
}