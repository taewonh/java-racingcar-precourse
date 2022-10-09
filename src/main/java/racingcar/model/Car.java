package racingcar.model;

import racingcar.common.Messages;
import racingcar.utils.NumberGenerator;

public class Car {

    private final String name;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    private Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public static Car generate(String name, NumberGenerator generator) {
        validateName(name);
        return new Car(name, generator);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(Messages.COLON.toString());
        for (int count = 0; count < position; count++) {
            builder.append(Messages.HYPHEN.toString());
        }
        Messages.EMPTY.println(builder.toString());
    }

    public void movePosition() {
        movePosition(numberGenerator.generate());
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private static void validateName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException(Messages.INVALID_EMPTY_CAR_NAME.toString());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH_CAR_NAME.toString());
        }
    }

    private void movePosition(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
