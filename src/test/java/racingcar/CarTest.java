package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_생성() {
        String name = "tw";
        Car car = new Car(name);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    public void 공백_이름_자동차_생성() {
        String name = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(name);
        });
    }

    @Test
    public void 글자수_초과_이름_자동차_생성() {
        String name = "123456";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(name);
        });
    }

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("name");
        car.increaseProgress(4);
        Assertions.assertEquals(1, car.getProgress());
    }

    @Test
    public void 자동차_멈춤_테스트() {
        Car car = new Car("name");
        car.increaseProgress(3);
        Assertions.assertEquals(0, car.getProgress());
    }
}
