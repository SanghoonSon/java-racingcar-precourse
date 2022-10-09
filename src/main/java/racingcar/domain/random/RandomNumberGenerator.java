package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    public RandomNumber create() {
        int number = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        return new RandomNumber(number);
    }
}
