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

    @Test
    public void 이동_횟수_입력() {
        Cars cars = new Cars();
        String count = "5";
        cars.inputCount(count);
        Assertions.assertEquals(Integer.parseInt(count), cars.getCount());
    }

    @Test
    public void 이동_횟수_미입력_테스트() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount(null);
        });
    }

    @Test
    public void 이동_횟수_숫자가_아닌_문자_입력_테스트() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount("null");
        });
    }

    @Test
    public void 이동_횟수_0_입력_테스트() {
        Cars cars = new Cars();
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> {
            cars.inputCount("0");
        });
    }
}
