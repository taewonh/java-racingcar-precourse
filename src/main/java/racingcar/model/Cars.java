package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.common.Messages;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(String carNames) {
        validateCarNames(carNames);
        List<Car> registerCars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            Car car = Car.generate(name, () -> Randoms.pickNumberInRange(1, 9));
            registerCars.add(car);
        }
        cars.addAll(registerCars);
    }

    public boolean isNotRegisteredCars() {
        return cars.isEmpty();
    }

    private static void validateCarNames(String carNames) {
        if (Messages.EMPTY.equals(carNames) || carNames.split(Messages.COMMA.toString()).length == 0) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_REGISTER_CAR_NAMES.toString());
        }
    }
}
