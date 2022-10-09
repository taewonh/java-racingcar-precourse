package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.property.CarName;

public class CarTest {

    @Test
    @DisplayName("자동차 생성")
    public void testGenerateCar() {
        String name = "tw";
        CarName carName = generateCarName(name);
        Car car = Car.generate(carName, null);
        Assertions.assertEquals(name, car.getName());
    }

    @Test
    @DisplayName("자동자 전진 테스트")
    public void testMovePosition() {
        CarName carName = generateCarName("name");
        Car car = Car.generate(carName, () -> 4);
        car.movePosition();
        Assertions.assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("자동차 멈춤 테스트")
    public void testNotMovePosition() {
        CarName carName = generateCarName("name");
        Car car = Car.generate(carName, () -> 3);
        car.movePosition();
        Assertions.assertEquals(0, car.getPosition());
    }

    private CarName generateCarName(String name) {
        return CarName.generate(name);
    }
}
