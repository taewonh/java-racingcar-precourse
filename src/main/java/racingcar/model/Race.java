package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.NumberGenerator;

public class Race {

    private static final int START_NUMBER = 1;

    private static final int END_NUMBER = 9;

    private final NumberGenerator numberGenerator = () -> Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);

    private final List<Car> registeredCars = new ArrayList<>();

    private int attemptCount = 0;

    public void registerCars(String carNames) {
        carNames = trimCarNames(carNames);
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            Car car = generateCar(carName);
            cars.add(car);
        }
        registeredCars.addAll(cars);
    }

    private String trimCarNames(String carNames) {
        return carNames.trim().replace(" ", "");
    }

    private void validateCarNames(String carNames) {
        if ("".equals(carNames)) {
            throw new IllegalArgumentException("참가할 자동차 이름 목록을 입력해주세요.");
        }
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("자동차는 2대 이상부터 등록할 수 있습니다.");
        }
        if (carNames.split(",").length == 0) {
            throw new IllegalArgumentException("참가할 자동차를 입력해주세요.");
        }
    }

    private Car generateCar(String carName) {
        return new Car(carName, numberGenerator);
    }

    public List<Car> getRegisteredCars() {
        return registeredCars;
    }

    public void inputAttemptCount(String attemptCount) {
        if ("".equals(attemptCount)) {
            throw new IllegalArgumentException("이동 횟수에 공백 입력은 허용되지 않습니다.");
        }
        if ("0".equals(attemptCount)) {
            throw new IllegalArgumentException("이동 횟수에 0은 지정할 수 없습니다.");
        }
        try {
            this.attemptCount = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 문자는 입력할 수 없습니다.");
        }
    }

    public boolean notRegisteredCars() {
        return registeredCars.isEmpty();
    }

    public boolean isZeroAttemptCount() {
        return attemptCount == 0;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
