package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Race;

public class RaceController {

    private final Race race;

    public RaceController() {
        race = new Race();
        readyToRace();
    }

    public void readyToRace() {
        System.out.println("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        while (race.notRegisteredCars()) {
            inputRegisterCarNames();
        }
        System.out.println("시도할 회수는 몇회인가요?");
        while (race.isZeroAttemptCount()) {
            inputAttemptCount();
        }
    }

    private void inputRegisterCarNames() {
        try {
            race.registerCars(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }

    private void inputAttemptCount() {
        try {
            race.inputAttemptCount(Console.readLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
        }
    }

    private void printErrorMessage(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
