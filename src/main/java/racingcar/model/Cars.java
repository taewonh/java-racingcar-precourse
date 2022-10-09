package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.property.CarName;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addCars(String carNames) {
        CarName.validateNames(carNames);
        List<Car> registerCars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            CarName carName = CarName.generate(name);
            Car car = Car.generate(carName, () -> Randoms.pickNumberInRange(1, 9));
            registerCars.add(car);
        }
        cars.addAll(registerCars);
    }

    public boolean isNotRegisteredCars() {
        return cars.isEmpty();
    }
}
