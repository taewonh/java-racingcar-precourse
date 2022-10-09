package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.Messages;
import racingcar.model.Race;

public class RaceController {

    private final Race race;

    public RaceController() {
        race = new Race();
        readyRace();
        startRace();
    }

    public void readyRace() {
        Messages.INPUT_REGISTER_CAR_NAMES.println();
        while (race.isNotRegisteredCars()) {
            inputRegisterCarNames();
        }
        Messages.INPUT_ATTEMPT_COUNT.println();
        while (race.isNotInputAttemptCount()) {
            inputAttemptCount();
        }
    }

    public void startRace() {
        Messages.EMPTY.println();
        Messages.RESULT_EXECUTE.println();
        race.start();
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
        Messages.ERROR.println(e.getMessage());
    }
}
