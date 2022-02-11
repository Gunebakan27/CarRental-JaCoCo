import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class CarRentalTesterTest {
    CarRentalTester instance;
    CarAndBookingDates cb;
    InputOutput inputOutput;
    String input;
    InputStream in;
    @BeforeEach
    void setup() {
        instance = new CarRentalTester();
        cb = new CarAndBookingDates();
        inputOutput = new InputOutput();
        input="";
        in = new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void main() {
        String[]args={""};
        input = "1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()->  instance.main(args));

    }
}