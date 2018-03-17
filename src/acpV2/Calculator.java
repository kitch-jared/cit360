package acpV2;

import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        
        Controller app = new Controller();        
        
        app.mapOption("Menu", new Menu());
        app.mapOption("1", new Addition());
        app.mapOption("2", new Subtraction());
        app.mapOption("3", new Multiplication());
        app.mapOption("4", new Division());
        app.mapOption("5", new Quit());
        app.mapOption("Invalid", new Invalid());
        
        initiate(app);
    }

    private static void initiate(Controller app) {
        app.handleRequest("Menu");
        
        Scanner in = new Scanner(System.in);
        String option = in.nextLine();

        if (app.operationMap.containsKey(option)==true) {
            app.handleRequest(option);
        } else {
            app.handleRequest("Invalid");
        }
        
        initiate(app);
    }
    
}