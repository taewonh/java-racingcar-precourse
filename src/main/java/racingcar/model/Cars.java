package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.NumberGenerator;

public class Cars {

    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private final NumberGenerator numberGenerator = () -> Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

    private final List<Car> cars = new ArrayList<>();

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
        cars.add(new Car(name, numberGenerator));
    }
    public List<Car> getCars() {
        return cars;
    }

    public void inputCount(String count) {
        if (count == null) {
            throw new IllegalArgumentException("이동 횟수에 공백 입력은 허용되지 않습니다.");
        }
        if ("0".equals(count)) {
            throw new IllegalArgumentException("이동 횟수에 0은 지정할 수 없습니다.");
        }
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다.");
        }
    }

    public int getCount() {
        return 5;
    }
}
