package racingcar.model;

import racingcar.utils.NumberGenerator;

public class Car {

    private final String name;

    private int position = 0;

    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        checkName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    private static void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름을 지정해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하여야 합니다.");
        }
    }

    public void movePosition() {
        movePosition(numberGenerator.generate());
    }

    private void movePosition(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
