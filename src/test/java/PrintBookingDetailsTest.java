import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PrintBookingDetailsTest {
    PrintBookingDetails instance;
    Car car;
    Customer customer;
    CarBooking carBooking;

    @BeforeEach
    void setUp() {
        instance=new PrintBookingDetails();
        car=new Car(2.2,"Car", "Standart");
        customer=new Customer("Name","Email","Address");
        carBooking=new CarBooking(LocalDate.now(),LocalDate.now().plusDays(1),1);
    }

    @Test
    void printBookingDetails() {
        instance.printBookingDetails(carBooking,customer);
//        assertEquals( "Name",customer.getCustomerName());
    }
}