package racingcar.model.property;

public class Position {

    private int number;

    public Position() {
        number = 0;
    }

    public void move(int number) {
        if (number >= 4) {
            this.number++;
        }
    }

    public int getNumber() {
        return number;
    }

    public Position compare(Position other) {
        if (other == null) {
            return this;
        }
        if (other.number >= number) {
            return other;
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Position) {
            return ((Position) o).number == number;
        }
        return false;
    }
}
