package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Cars 클래스")
class CarsTest {

    @Test
    @DisplayName("자동차 컬렉션 생성시 중복 된 이름이 있으면 안된다")
    void create_cars_if_duplicated_name_throw_exception_test() {
        // given
        List<Car> racingCars = new ArrayList<>();
        racingCars.add(new Car("test", 0));
        racingCars.add(new Car("test1", 0));
        racingCars.add(new Car("test2", 0));
        racingCars.add(new Car("test2", 0));

        // when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cars(racingCars));

        // then
        assertEquals("차 이름은 중복될 수 없습니다.", exception.getMessage());
    }
}