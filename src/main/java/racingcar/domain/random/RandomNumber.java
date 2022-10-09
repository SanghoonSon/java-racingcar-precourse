package racingcar.domain.random;

public class RandomNumber {

    private final int number;

    public RandomNumber(int number) {
        validateRandomNumber(number);
        this.number = number;
    }

    private void validateRandomNumber(int number) {
        if(!inRange(0, number, 9)) {
            throw new IllegalArgumentException("0 ~ 9 사이 랜덤값이 주어져야 합니다.");
        }
    }

    private boolean inRange(int lower, int number, int upper) {
        return lower <= number && number <= upper;
    }

    public boolean isMoreThan(int number) {
        return this.number >= number;
    }

    public int value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomNumber that = (RandomNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
