package acpV2;

public class Quit implements Handler{
    @Override
    public void handleIt() {
        System.exit(0);
    }
}
