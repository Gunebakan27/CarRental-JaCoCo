import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MenuDisplayTest {
    MenuDisplay instance;
    InputOutput inputOutput;
    String input;
    InputStream in;

    @BeforeEach
    void setUp() {
       instance=new MenuDisplay();
       inputOutput = new InputOutput();
       input="";
       in = new ByteArrayInputStream(input.getBytes());
       MenuDisplay.CARLIST="src/main/java/CarList.csv";
    }

    @Test
    void getCARLIST() {
        String expected="src/main/java/CarList.csv";
        assertEquals(expected,instance.getCARLIST());

    }

    @Test
    void displayCarList() throws IOException {

        assertEquals(5,instance.displayCarList());
//        assertNotEquals(0,instance.displayCarList());
    }
    @Test
    void fileRead() {
        MenuDisplay.CARLIST="src/main/java/CarListe.csv";
        assertEquals("Source file cannot be opened.",instance.fileRead());

    }

    @Test
    void getSelection1() {
        input = "1";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals(1, instance.getSelection());

    }
        @Test
        void getSelection2(){
        input = "2";
           in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assertEquals(2, instance.getSelection());
        }
//    @Test
//    void getSelection3(){
//        input = "1";
//        in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        instance.getSelection();
//        input = "3";
//        in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        instance.displayCarList();
//
////        assertEquals(3, instance.getSelection());
//    }
//    @Test
//    void getSelection4(){
//        input = "4";
//        in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertEquals(4, instance.getSelection());
//    }
//    @Test
//    void getSelection5(){
//        input = "5";
//        in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        assertEquals(5, instance.getSelection());
//    }
    @Test
    void getSelectionA(){
        input = "A";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.getSelection());
    }
    @Test
    void getSelection0(){
       input = "0";
     in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(NoSuchElementException.class,()-> instance.getSelection());
    }


}