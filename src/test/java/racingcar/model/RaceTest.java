package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    @DisplayName("시도 횟수 입력")
    public void testInputAttemptCount() {
        Race race = new Race();
        String count = "5";
        race.inputAttemptCount(count);
        Assertions.assertEquals(Integer.parseInt(count), race.getAttemptCount());
    }

    @Test
    @DisplayName("시도 횟수 공백 입력")
    public void testInputEmptyAttemptCount() {
        Race race = new Race();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            race.inputAttemptCount("");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 시도 횟수 입력")
    public void testInputNotIntegerAttemptCount() {
        Race race = new Race();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            race.inputAttemptCount("null");
        });
    }

    @Test
    @DisplayName("시도 횟수 0 입력")
    public void testInputZeroAttemptCount() {
        Race race = new Race();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            race.inputAttemptCount("0");
        });
    }
}
