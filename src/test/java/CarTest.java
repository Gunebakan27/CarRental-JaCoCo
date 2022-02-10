import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
Car car=new Car(0,"Volvo","Standart");
    @Test
    void setCarRate() {
        double value = 3.33;
        car.setCarRate(value);
        assertEquals(value, car.getCarRate());
    }

    @Test
    void setCarName() {
        String value = "Volvo";
        car.setCarName(value);
        assertEquals(value, car.getCarName());
    }

    @Test
    void setCarType() {
        String value = "Standart";
        car.setCarType(value);
        assertEquals(value, car.getCarType());
    }
}