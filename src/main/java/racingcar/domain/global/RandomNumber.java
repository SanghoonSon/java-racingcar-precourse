package racingcar.domain.global;

public class RandomNumber {

    private final int number;

    public RandomNumber(int number) {
        this.number = number;
    }

    public boolean isGraterThan(int number) {
        return this.number > number;
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
