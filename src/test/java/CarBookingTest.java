import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CarBookingTest {

    LocalDate startDate= LocalDate.now();
    LocalDate endDate= startDate.plusDays(1);
    int carNumber=2;

    CarBooking instance;
//    Car car=new Car(0,"Volvo","Premium");

    @BeforeEach
    void setup(){
        MenuDisplay.CARLIST="src/main/java/CarList.csv";
        instance=new CarBooking(startDate,endDate,carNumber);
    }

@Test
void makeCarBooking(){

}

    @Test
    void fileRead()  {
        MenuDisplay.CARLIST="src/main/java/CarListe.csv";

      assertEquals("Source file cannot be opened.",instance.fileRead());


    }
    @Test
    void carType(){
        String expected="Premium";
        instance.setCarType(expected);
        instance.carType(expected);
        assertEquals(expected, instance.getCar().getCarType());
    }

    @Test
    void calculateTotalDays() {
        instance.calculateTotalDays();
        assertEquals(2, instance.getTotalDays());
    }

    @Test
    void calculateCost() {
        instance.calculateCost(5.5,10);
        assertEquals(55, instance.getCost(),0.0);
    }

    @Test
    void getStartDate() {
        LocalDate expectedStartdate = LocalDate.now();
        instance.setStartDate(expectedStartdate);
        assertEquals(expectedStartdate,instance.getStartDate());
    }

    @Test
    void getEndDate() {

        LocalDate expectedEndDate= LocalDate.now().plusDays(1);
instance.setEndDate(expectedEndDate);
assertEquals(expectedEndDate,instance.getEndDate());
    }

    @Test
    void getCarNumber() {
        int excpectedCarNumber=1;
        instance.setCarNumber(excpectedCarNumber);
        assertEquals(excpectedCarNumber,instance.getCarNumber());
    }

    @Test
    void getNewRate() {
        double expectedNewRate=5.5;
        instance.setNewRate(expectedNewRate);
        assertEquals(expectedNewRate,instance.getNewRate(),0.0);
    }

    @Test
    void getCarType() {
        String expectedCarType="Standart";
        instance.setCarType(expectedCarType);
        assertEquals(expectedCarType, instance.getCarType());
    }

    @Test
    void getCar() {
        Car car=new Car(5.5,"Volvo","Standart");
        instance.setCar(car);
        assertEquals(car, instance.getCar());

    }
@Test
    void getTotalDays() {
        long expectedTotalDays=10;
        instance.setTotalDays(expectedTotalDays);
        assertEquals(expectedTotalDays, instance.getTotalDays());
}
@Test
    void getCost() {
        double expectedCost=5.5;
        instance.setCost(expectedCost);
        assertEquals(expectedCost, instance.getCost(),0.0);
}
}