package racingcar.model.property;

import racingcar.common.Messages;

public class CarName {

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName generate(String name) {
        validateName(name);
        return new CarName(name);
    }

    public static void validateNames(String names) {
        if (Messages.EMPTY.equals(names) || names.split(Messages.COMMA.toString()).length == 0) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_REGISTER_CAR_NAMES.toString());
        }
    }

    public static void validateName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException(Messages.INVALID_EMPTY_CAR_NAME.toString());
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(Messages.INVALID_LENGTH_CAR_NAME.toString());
        }
    }

    public String getName() {
        return name;
    }
}
