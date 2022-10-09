package racingcar.model.property;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.Messages;

public class CarNames {

    private final List<CarName> names = new ArrayList<>();

    public static CarNames generate(String names) {
        validate(names);
        List<CarName> carNames = new ArrayList<>();
        for (String name : names.split(",")) {
            CarName carName = CarName.generate(name);
            carNames.add(carName);
        }
        return new CarNames(carNames);
    }
    
    public List<CarName> getNames() {
        return names;
    }

    private CarNames(List<CarName> carNames) {
        this.names.addAll(carNames);
    }

    private static void validate(String names) {
        if (Messages.EMPTY.equals(names) || names.split(Messages.COMMA.toString()).length == 0) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_REGISTER_CAR_NAMES.toString());
        }
    }
}
