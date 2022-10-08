package racingcar.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("자동차 목록 입력")
    public void testRegisterCars() {
        String names = "pobi,crong,honux";
        Cars cars = new Cars();
        cars.registerCars(names);
        List<Car> carList = cars.getCars();
        Assertions.assertEquals(3, carList.size());
    }

    @Test
    @DisplayName("자동차 목록 입력 시 공백 문자 or null 입력")
    public void testRegisterEmptyCars() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars(null);
        });
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars("");
        });
    }

    @Test
    @DisplayName("자동차 1대만 존재하는 목록 입력")
    public void testRegisterCar() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars("pobi");
        });
    }

    @Test
    @DisplayName("시도 횟수 입력")
    public void testInputAttemptCount() {
        Cars cars = new Cars();
        String count = "5";
        cars.inputCount(count);
        Assertions.assertEquals(Integer.parseInt(count), cars.getCount());
    }

    @Test
    @DisplayName("시도 횟수 공백 입력")
    public void testInputEmptyAttemptCount() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount(null);
        });
    }

    @Test
    @DisplayName("숫자가 아닌 시도 횟수 입력")
    public void testInputNotIntegerAttemptCount() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount("null");
        });
    }

    @Test
    @DisplayName("시도 횟수 0 입력")
    public void testInputZeroAttemptCount() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount("0");
        });
    }
}
