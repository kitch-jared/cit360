package acpV2;

import java.util.*;

public class Subtraction implements Handler {
    @Override
    public void handleIt() {
        int firstNumber, secondNumber;

        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a number:");
        firstNumber = in.nextInt();
        System.out.println("Enter another number:");
        secondNumber = in.nextInt();

        System.out.println("\nThe difference in " + firstNumber + " and " + secondNumber + " is " + (firstNumber-secondNumber));

    }
}
