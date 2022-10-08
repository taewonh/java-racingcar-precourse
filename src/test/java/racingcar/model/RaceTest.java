package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    @DisplayName("자동차 목록 입력")
    public void testRegisterCars() {
        String names = "pobi,crong,honux";
        Race race = new Race();
        race.registerCars(names);
        List<Car> carList = race.getRegisteredCars();
        Assertions.assertEquals(3, carList.size());
    }

    @Test
    @DisplayName("자동차 목록 입력 시 공백 문자 or null 입력")
    public void testRegisterEmptyCars() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Race().registerCars(null);
        });
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Race().registerCars("");
        });
    }

    @Test
    @DisplayName("자동차 1대만 존재하는 목록 입력")
    public void testRegisterCar() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Race().registerCars("pobi");
        });
    }

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
            race.inputAttemptCount(null);
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
