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

    public void movePosition() {
        movePosition(numberGenerator.generate());
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

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
