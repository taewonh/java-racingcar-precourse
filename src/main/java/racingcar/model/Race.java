package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.common.Messages;
import racingcar.utils.NumberGenerator;

public class Race {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private final NumberGenerator numberGenerator = () -> Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    private final List<Car> registeredCars = new ArrayList<>();
    private int attemptCount = 0;
    private int topPosition = 0;

    public void registerCars(String carNames) {
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            Car car = Car.generate(name, numberGenerator);
            cars.add(car);
        }
        registeredCars.addAll(cars);
    }

    public void inputAttemptCount(String attemptCount) {
        if (Messages.EMPTY.equals(attemptCount) || Messages.ZERO.equals(attemptCount)) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_ATTEMPT_COUNT.toString());
        }
        try {
            this.attemptCount = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_ATTEMPT_COUNT.toString());
        }
    }

    public boolean isNotRegisteredCars() {
        return registeredCars.isEmpty();
    }

    public boolean isNotInputAttemptCount() {
        return attemptCount == 0;
    }

    public void start() {
        for (int count = 0; count < attemptCount; count++) {
            progress();
            Messages.EMPTY.println();
        }
        printWinners();
    }

    private void validateCarNames(String carNames) {
        if (Messages.EMPTY.equals(carNames)
                || carNames.split(Messages.COMMA.toString()).length == 0) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_REGISTER_CAR_NAMES.toString());
        }
    }

    private void progress() {
        for (Car car : registeredCars) {
            car.movePosition();
            refreshTopPosition(car);
            printCar(car);
        }
    }

    private void refreshTopPosition(Car car) {
        if (car.getPosition() > topPosition) {
            topPosition = car.getPosition();
        }
    }

    private void printCar(Car car) {
        StringBuilder builder = new StringBuilder();
        builder.append(car.getName())
                .append(Messages.COLON.toString());
        for (int count = 0; count < car.getPosition(); count++) {
            builder.append(Messages.HYPHEN.toString());
        }
        Messages.EMPTY.println(builder.toString());
    }

    private void printWinners() {
        StringBuilder builder = new StringBuilder();
        builder.append(Messages.WINNERS.toString());
        for (Car car : registeredCars) {
            buildWinner(builder, car);
        }
        builder.setLength(builder.length() - 2);
        Messages.EMPTY.println(builder.toString());
    }

    private void buildWinner(StringBuilder builder, Car car) {
        if (car.getPosition() == topPosition) {
            builder.append(car.getName())
                    .append(Messages.COMMA.toString())
                    .append(Messages.BLANK.toString());
        }
    }

    List<Car> getRegisteredCars() {
        return registeredCars;
    }

    int getAttemptCount() {
        return attemptCount;
    }
}
