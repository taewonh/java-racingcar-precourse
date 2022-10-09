package racingcar.model;

import java.util.List;
import racingcar.common.Messages;
import racingcar.model.property.Position;

public class Race {

    private int attemptCount;
    private Position topPosition;

    public Race() {
        attemptCount = 0;
        topPosition = new Position();
    }

    public void inputAttemptCount(String attemptCount) {
        validateAttemptCount(attemptCount);
        try {
            this.attemptCount = Integer.parseInt(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.INVALID_ATTEMPT_COUNT.toString());
        }
    }

    public void start(List<Car> cars) {
        for (int count = 0; count < attemptCount; count++) {
            progress(cars);
            Messages.EMPTY.println();
        }
        printWinners(cars);
    }

    public boolean isNotInputAttemptCount() {
        return attemptCount == 0;
    }

    private static void validateAttemptCount(String attemptCount) {
        if (Messages.EMPTY.equals(attemptCount) || Messages.ZERO.equals(attemptCount)) {
            throw new IllegalArgumentException(Messages.NOT_INPUT_ATTEMPT_COUNT.toString());
        }
    }

    private void progress(List<Car> cars) {
        for (Car car : cars) {
            car.move();
            car.print();
            refreshTopPosition(car);
        }
    }

    private void refreshTopPosition(Car car) {
        Position carPosition = car.getPosition();
        topPosition = topPosition.compare(carPosition);
    }

    private void printWinners(List<Car> cars) {
        StringBuilder builder = new StringBuilder();
        builder.append(Messages.WINNERS.toString());
        for (Car car : cars) {
            buildWinner(builder, car);
        }
        builder.setLength(builder.length() - 2);
        Messages.EMPTY.println(builder.toString());
    }

    private void buildWinner(StringBuilder builder, Car car) {
        if (car.getPosition() == topPosition) {
            builder.append(car.getName()).append(Messages.COMMA.toString()).append(Messages.BLANK.toString());
        }
    }

    int getAttemptCount() {
        return attemptCount;
    }
}
