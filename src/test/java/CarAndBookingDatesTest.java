import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.*;

class CarAndBookingDatesTest {
    CarAndBookingDates instance;
    InputOutput inputOutput;
    String input;
    InputStream in;
    @BeforeEach
    void setup(){
        instance=new CarAndBookingDates();
        instance.year=0;
        instance.month=0;
        instance.day=0;
        inputOutput = new InputOutput();
        input="";
        in = new ByteArrayInputStream(input.getBytes());
    }
    @Test
    void carSelectionTestInteger(){
        input = "a";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()->instance.carSelection(0));
    }

    @Test
    void carSelectionTestAvailability0(){

       input = "0";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()->instance.carSelection(0));
//        assertEquals(1,instance.carSelection(1));
    }
    @Test
    void carSelectionTestAvailability2(){
        InputOutput inputOutput= new InputOutput();

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()->instance.carSelection(0));

        input = "1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(1,instance.carSelection(1));
    }

    @Test
    void getCarBookingDateFull ()  {


        instance.year=2021;
        instance.month=6;
        instance.day=21;
        String date = instance.day + "/" + instance.month + "/" + instance.year;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate localDate = LocalDate.parse(date, dateFormatter);
        assertEquals(localDate,instance.getCarBookingDateFull());


    }

    @Test
    void validateYear(){
            assertTrue( instance.validateYear("2020"));
            assertFalse( instance.validateYear("2019"));
            assertFalse( instance.validateYear("2030"));
    }
    @Test
    void validateMonth(){
        assertTrue( instance.validateMonth("10"));
        assertFalse( instance.validateMonth("0"));
        assertFalse( instance.validateMonth("13"));
    }


    @Test
     public   void validateDaysInFebruar() {
            instance.month = 2;
            instance.year = 2020;
            assertTrue (instance.validateDay("29"));
            assertFalse (instance.validateDay("30"));
            instance.year=2021;
            assertTrue (instance.validateDay("28"));
            assertFalse (instance.validateDay("29"));
        }
    @ParameterizedTest
    @CsvSource(value={"4","6","8","11"})
    void validateDays30Months(int month){
        instance.year=2021;
        instance.month=month;
        assertTrue (instance.validateDay("30"));
        assertFalse (instance.validateDay("31"));
 }
    @ParameterizedTest
    @CsvSource(value={"1","3","5","7","9","10","12"})
    void validateDays31Months(int month){
        instance.year=2021;
        instance.month=month;
        assertTrue (instance.validateDay("31"));
        assertFalse (instance.validateDay("32"));
    }
    @Test
    void validateDay(){
        assertFalse(instance.validateDay("0"));
    }



    @Test
    void promptForYear() throws Exception{
//        InputOutput inputOutput= new InputOutput();

        String input = "2021";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(2021, instance.promptForYear());

        input ="0";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForYear());

        input ="2020a";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForYear());

    }

    @Test
    void promptForMonth() {
//        InputOutput inputOutput= new InputOutput();

        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(6, instance.promptForMonth());
        input ="0";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForMonth());
        input ="6a";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForMonth());
    }

    @Test
    void promptForDay() {
//        InputOutput inputOutput= new InputOutput();

        String input = "21";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(21, instance.promptForDay());

        input ="0";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForDay());

        input ="21a";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.promptForDay());
    }

}