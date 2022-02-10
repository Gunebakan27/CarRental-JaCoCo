import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PremiumCarTest {
    Car car=new Car(0,"Volvo","Premium");
    PremiumCar PremiumCar=new PremiumCar(2,"Volvo","Premium");

    @Test
    void getCarRate() {
        car.setCarRate(2);
        assertEquals(2.10,PremiumCar.getCarRate());
    }
}