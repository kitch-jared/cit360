package acpV2;

public class Menu implements Handler {
    @Override
    public void handleIt() {
       System.out.println("\n\nWe can perform several functions (Type the number) :");
       System.out.println("----------------------------------------------------");
       System.out.println("[1] Addition");
       System.out.println("[2] Subtraction");
       System.out.println("[3] Multiplication");
       System.out.println("[4] Division");
       System.out.println("[5] Quit");
    }
}
