package racingcar;

public class Car {

    private int progress = 0;

    void increaseProgress(int num) {
        if (num >= 4) {
            progress++;
        }
    }

    public int getProgress() {
        return progress;
    }
}
