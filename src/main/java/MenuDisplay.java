/*
 * Console based program that will allow a customer to make a partial booking
 * of a vehicle through a car hire company.
 * Max Sova CSE1OFX Assessment 3
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Max Sova CSE1OFX Assessment 3
 */
public class MenuDisplay {

    //Declare input file name as constant.
 static String CARLIST = "src/main/java/CarList.csv";
    ArrayList<String[]> table = new ArrayList<String[]>();

    public static String getCARLIST() {
        return CARLIST;
    }

    /**
     * Displays list of cars to user, returns number of available cars
     *
     * @return numberOfCars
     */
    public int displayCarList() {

        //Initialyze variable
        int carsAvailable = 0;

        //Print header
        for (int i = 0; i < 90; i++) {
            System.out.print("*");
        }
        System.out.println("\n                               Welcome to "
                + "Carrington Car Rental");
        for (int i = 0; i < 90; i++) {
            System.out.print("*");
        }
        System.out.println("\nCars available for booking:");

        for (int i = 0; i < 90; i++) {
            System.out.print("_");
        }
        System.out.println();//end of header



        //Add header elements to the array table
        table.add(new String[]{"Car No.", "Car Name", "Seats", "Transmission",
                "Car Type", "Rate/Day($)"});
        table.add(new String[]{"-------", "--------", "-----", "------------",
                "--------", "-----------"});
        fileRead();

        //Print table
        for (String[] arr : table) {
            for (String item : arr) {
                System.out.format("%-16s", item);
            }

            System.out.println("\n");
        }//end of table

        for (int i = 0; i < 90; i++) {
            System.out.print("_");
        }//end of table

        //Calculate number of cars
        carsAvailable = table.size() - 2;
        System.out.println("\nTotal " + carsAvailable + " cars available\n");
        System.out.println("**Note for premium cars, there's additional 5%"
                + " insurance access applied \n to the car rate.");
        System.out.println();
        System.out.println();

        return carsAvailable;
    }


    //Instantiate file reader, access file inside try-catch block
    public String fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader(CARLIST))) {
            String line;
            //Iterate through car list
            while ((line = br.readLine()) != null) {
                //Add car records to array
                String[] values = line.split(",");
                table.add(values);
            }
            br.close();
        } catch (Exception e) {//try/catch file not found exception

//        System.exit(1);//exiting if file not found
        }return "Source file cannot be opened.";}

    /**
     * Prompt to make booking or exit from the system.
     *
     * @return selection
     */
    public int getSelection() {

        //initialyze variable
        int option = 0;

        Scanner keyboard = new Scanner(System.in);//Initialize Scanner 
        do {// Start selection loop.

            // Prompt for keyboard input.
            System.out.println();

            for (int i = 0; i < 50; i++) {
                System.out.print("*");
            }
            System.out.println("\nSelect from one of the following options."
                    + "\n");
            System.out.println("1. To make a booking");
            System.out.println("2. To exit the system" + "\n");
            System.out.print("Enter your selection:  ");

            while (!keyboard.hasNextInt()) {//check if the input is integer.
                String input = keyboard.next();
                System.out.printf("\"%s\" is not a valid selection.Try again."
                        + "\n", input);//Print error message.
            }
            option = keyboard.nextInt();//Receive scanner input, store as option

            //restart validation loop if input is invalid.
        } while (!(option == 1 || option == 2));//End of validation.

        return option;
    }

}