import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {
    Customer instance;

    @BeforeEach
    void setup(){

     instance=new Customer("Name", "Email", "Address");

    }

    @Test
    void setCustomerName() {
        instance.setCustomerName("Name");
        assertEquals("Name", instance.getCustomerName());
    }

    @Test
    void setCustomerEmail() {
        instance.setCustomerEmail("Email");
        assertEquals("Email", instance.getCustomerEmail());
    }

    @Test
    void setCustomerAddress() {
        instance.setCustomerAddress("Address");
    assertEquals("Address", instance.getCustomerAddress());
    }
}