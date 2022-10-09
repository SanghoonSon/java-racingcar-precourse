package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.random.RandomNumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Car 클래스")
class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("sona", 0);
    }

    @Test
    @DisplayName("자동차 생성시 이름을 가지고 있어야한다")
    void create_racing_car_with_name() {
        // given
        String name = "sona";

        // when
        Car car = new Car(name, 0);

        // then
        assertNotNull(car.getName(), "racing car의 name은 필수값입니다.");
        assertEquals(name, car.getName().value(), "racing car name이 다릅니다.");
    }

    @DisplayName("number가 0 ~ 3이면 멈추고 4 ~ 9이면 전진한다")
    @ParameterizedTest(name ="{displayName} number={0} ")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void move_racing_car(int inputNumber) {
        // given
        RandomNumber randomNumber = new RandomNumber(inputNumber);

        // when
        this.car.move(randomNumber);

        // then
        int expectedCount = inputNumber > 3 ? 1 : 0;
        int count = car.getPosition().count();
        assertEquals(expectedCount, count, "4 ~ 9의 값이 주어지면 전진해야합니다.");
    }
}