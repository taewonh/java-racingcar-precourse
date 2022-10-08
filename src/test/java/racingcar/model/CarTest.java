package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_생성() {
        String name = "tw";
        Car car = new Car(name, null);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    public void 공백_이름_자동차_생성() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null, null);
        });
    }

    @Test
    public void 글자수_초과_이름_자동차_생성() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("123456", null);
        });
    }

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("name", () -> 4);
        car.movePosition();
        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    public void 자동차_멈춤_테스트() {
        Car car = new Car("name", () -> 3);
        car.movePosition();
        Assertions.assertEquals(0, car.getPosition());
    }
}
