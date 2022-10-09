package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.property.CarName;
import racingcar.model.property.CarNames;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void generateCars(String names) {
        CarNames carNames = CarNames.generate(names);
        for (CarName carName : carNames.getNames()) {
            Car car = Car.generate(carName, () -> Randoms.pickNumberInRange(1, 9));
            cars.add(car);
        }
    }

    public boolean isNotRegisteredCars() {
        return cars.isEmpty();
    }
}
