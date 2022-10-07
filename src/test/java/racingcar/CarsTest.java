package racingcar;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    public void 자동차_추가() {
        String names = "pobi,crong,honux";
        Cars cars = new Cars();
        cars.registerCars(names);
        List<Car> carList = cars.getCars();
        Assertions.assertEquals(3, carList.size());
    }

    @Test
    public void 공백_자동차_추가() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars(null);
        });
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars("");
        });
    }

    @Test
    public void 자동차_한대만_추가() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            new Cars().registerCars("pobi");
        });
    }
}
