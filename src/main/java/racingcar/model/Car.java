package racingcar.model;

import racingcar.utils.RandomNumberUtil;

public class Car {

    private final String name;

    private int progress = 0;

    private RandomNumberUtil randomNumberUtil;

    public void setRandomNumberUtil(RandomNumberUtil randomNumberUtil) {
        this.randomNumberUtil = randomNumberUtil;
    }

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    private static void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름을 지정해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하여야 합니다.");
        }
    }

    public void increase() {
        increaseProgress(randomNumberUtil.generateNumber());
    }

    private void increaseProgress(int num) {
        if (num >= 4) {
            progress++;
        }
    }

    public int getProgress() {
        return progress;
    }

    public String getName() {
        return name;
    }
}
