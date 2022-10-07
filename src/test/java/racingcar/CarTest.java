package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car();
        car.increaseProgress(4);
        Assertions.assertEquals(1, car.getProgress());
    }

    @Test
    public void 자동차_멈춤_테스트() {
        Car car = new Car();
        car.increaseProgress(3);
        Assertions.assertEquals(0, car.getProgress());
    }
}
