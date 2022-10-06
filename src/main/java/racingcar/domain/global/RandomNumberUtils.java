package racingcar.domain.global;

import camp.nextstep.edu.missionutils.Randoms;

public abstract class RandomNumberUtils {

    private static final int RANDOM_NUMBER_MIN = 0;
    private static final int RANDOM_NUMBER_MAX = 9;

    public static RandomNumber getNumber() {
        int number = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
        return new RandomNumber(number);
    }
}
