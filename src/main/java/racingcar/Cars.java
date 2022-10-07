package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();
    public void registerCars(String names) {
        checkNames(names);
        String[] split = names.split(",");
        for (String name : split) {
            registerCar(name);
        }
    }

    private void checkNames(String names) {
        if (names == null || "".equals(names)) {
            throw new IllegalArgumentException("자동차 이름에 공백은 허용되지 않습니다.");
        }
        if (!names.contains(",")) {
            throw new IllegalArgumentException("자동차는 2대 이상부터 등록할 수 있습니다.");
        }
    }

    private void registerCar(String name) {
        cars.add(new Car(name));
    }
    public List<Car> getCars() {
        return cars;
    }
}
