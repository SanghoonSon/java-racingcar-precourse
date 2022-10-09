package racingcar.domain.car;

public class Position {

    private static final String MARK = "-";
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public int count() {
        return this.position;
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        for (int i=0; i < position; i++) {
            output.append(MARK);
        }
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
