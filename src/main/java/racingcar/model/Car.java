package racingcar.model;

import racingcar.common.Messages;
import racingcar.model.property.CarName;
import racingcar.utils.NumberGenerator;

public class Car {

    private final CarName name;
    private int position = 0;
    private final NumberGenerator numberGenerator;

    private Car(CarName name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public static Car generate(CarName name, NumberGenerator generator) {
        return new Car(name, generator);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName()).append(Messages.COLON.toString());
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
        return name.getName();
    }

    private void movePosition(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }
}
