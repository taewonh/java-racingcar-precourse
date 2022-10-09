package racingcar.model.property;

import racingcar.common.Messages;

public class CarName {

    private final String name;

    public static CarName generate(String name) {
        validate(name);
        return new CarName(name);
    }

    public String getName() {
        return name;
    }

    private CarName(String name) {
        this.name = name;
    }

    private static void validate(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException(Messages.INVALID_EMPTY_CAR_NAME.toString());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH_CAR_NAME.toString());
        }
    }
}
