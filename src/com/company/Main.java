package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    /********************************************
     * This is the method to get the user input *
     ********************************************/
    public static int getNumSides() {
        // Variable declarations
        Scanner scnr = new Scanner(System.in);    // Scanner object to get user input
        int numSides = 0;                         // number of sides on the die
        boolean validNumSides = false;            // boolean on whether input is valid

        // Keep looping until user input is valid
        while (!validNumSides) {
            // Prompt user on how many sides the die should have
            System.out.print("How many sides should each die have? ");
            numSides = scnr.nextInt();
            scnr.nextLine();

            // Validate whether the number of sides is two or more
            if (numSides < 2) {
                System.out.println("That is not a valid number of sides to a die.  Please try again");
            }
            else {
                validNumSides = true;
            }
        }

        // Return the number of sides
        return numSides;
    }

    /*************************************************
     * This method rolls a die and returns the value *
     *************************************************/
    public static int rollDie(int sides, String randomClassType) {
        // Variable declarations
        Random rand = new Random();      // Random object for rolling

        // Roll the die depending on class type
        if (randomClassType.equalsIgnoreCase("Math")) {
            return (int)(Math.random() * sides) + 1;
        }
        else {
            return rand.nextInt(sides)+1;
        }
    }

    /*************************************************************************
     * This method asks the user if they want to continue the program or not *
     *************************************************************************/
    public static boolean askUserYesNo() {
        // Variable declarations
        String userInput = "";                  // User input string
        Scanner scan = new Scanner(System.in);  // Scanner object for user input

        // Prompt user to enter yes or no
        System.out.print("(y/n): ");
        userInput = scan.nextLine();
        System.out.println("");

        // Validate whether user input is ok, and continue asking until right
        while (!userInput.equalsIgnoreCase("y") &&
                !userInput.equalsIgnoreCase("yes") &&
                !userInput.equalsIgnoreCase("n") &&
                !userInput.equalsIgnoreCase("no")) {
            System.out.println("That is not a valid input.  Please try again. ");
            System.out.print("(y/n): ");
            userInput = scan.nextLine();
            System.out.println("");
        }

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /**************************************************************
     * TODO: This method determines what kind of craps roll it is *
     **************************************************************/
    public static void crapsRoll(int die1, int die2) {
        // TODO: Need to make the method
        return;
    }

    /****************************
     * This is the main program *
     ****************************/
    public static void main(String[] args) {
        // Variable declarations
        boolean continueProgram = true;         // boolean to keep program running
        int numSides = 0;                       // number of sides of the dice
        int numRolls = 0;                       // number of times the dice was rolled
        int die1 = 0;                           // holds the roll result of die #1
        int die2 = 0;                           // holds the roll result of die #2
        String randomClassType = "Math";             // default to Math class
        Scanner scnr = new Scanner(System.in);  // Scanner object for user input

        // Welcome message
        System.out.println("Welcome to the Grand Circus Casino!\n");

        // Ask user if they want to use the Math class or Java random class
        System.out.print("Do you want to use the Java Random class? ");
        if (askUserYesNo() == true) {
            System.out.println("Ok, we will use the Java Random class.\n");
            randomClassType = "Java Random";
        }
        else {
            System.out.println("Ok, then we will use the Math class.\n");
        }

        while (continueProgram) {
            // Get user input
            numSides = getNumSides();
            System.out.println("");

            // Increase the number of rolls, and let the user know how many rolls.
            System.out.println("Roll " + ++numRolls + ":");

            // Roll the dice, increase number of rolls
            die1 = rollDie(numSides, randomClassType);
            die2 = rollDie(numSides, randomClassType);

            // Print the results of the roll
            System.out.println(die1);
            System.out.println(die2);
            System.out.println("");

            // Is it some kind of craps roll if dices are six sides?
            // TODO:  This should be modified to work eventually
            if (numSides == 6) {
                crapsRoll(die1, die2);
            }

            // Ask the user if they want to continue
            System.out.print("Do you want to continue? ");
            continueProgram = askUserYesNo();
        }

        // Exit message
        System.out.println("Goodbye!");
    }
}
