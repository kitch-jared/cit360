package acpV2;

public class Invalid implements Handler {
    @Override
    public void handleIt() {
        System.out.println("Please enter a valid command");
    }
}
