package racingcar.model;

import racingcar.common.Messages;
import racingcar.model.property.CarName;
import racingcar.model.property.Position;
import racingcar.utils.NumberGenerator;

public class Car {

    private final CarName name;
    private final Position position;
    private final NumberGenerator numberGenerator;

    private Car(CarName name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
        this.position = new Position();
    }

    public static Car generate(CarName name, NumberGenerator generator) {
        return new Car(name, generator);
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName()).append(Messages.COLON.toString());
        for (int count = 0; count < position.getNumber(); count++) {
            builder.append(Messages.HYPHEN.toString());
        }
        Messages.EMPTY.println(builder.toString());
    }

    public void move() {
        position.move(numberGenerator.generate());
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
