package racingcar.domain.random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("DefaultRandomNumberGenerator 클래스")
class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0 ~ 9 사이 랜덤값을 리턴")
    void create_random_number_test() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        RandomNumber number = randomNumberGenerator.create();

        // then
        assertTrue(number.value() > 0 && number.value() < 10, "0 ~ 9 사이의 랜덤값이어야 합니다.");
    }
}