package acpV2;

import java.util.*;

public class Division implements Handler {
    @Override
    public void handleIt() {
        int firstNumber, secondNumber;

        Scanner in = new Scanner(System.in);
        System.out.println("\nEnter a number:");
        firstNumber = in.nextInt();
        System.out.println("Enter another number:");
        secondNumber = in.nextInt();

        System.out.println("\nThe quotient of " + firstNumber + " and " + secondNumber + " is " + (firstNumber/secondNumber));

    }
}
