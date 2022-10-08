package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 생성")
    public void testGenerateCar() {
        String name = "tw";
        Car car = new Car(name, null);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    @DisplayName("이름이 공백인 자동차 생성")
    public void testGenerateEmptyNameCar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null, null);
        });
    }

    @Test
    @DisplayName("이름 글자수를 초과하는 자동차 생성")
    public void testGenerateExceededNameCharacterCountCar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("123456", null);
        });
    }

    @Test
    @DisplayName("자동자 전진 테스트")
    public void testMovePosition() {
        Car car = new Car("name", () -> 4);
        car.movePosition();
        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 멈춤 테스트")
    public void testNotMovePosition() {
        Car car = new Car("name", () -> 3);
        car.movePosition();
        Assertions.assertEquals(0, car.getPosition());
    }
}
