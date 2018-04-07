package application;

import mvc.View;

import java.util.Observable;
import java.util.Scanner;

public class CatalogView extends View {
    CatalogController catalogController;
    private Scanner in;

    public CatalogView(){
        in = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("Select the option");
        System.out.println("1. Add new device");
    }

    public void askForCommand() {
        displayMenu();
        String command = in.nextLine();
        catalogController.execute(command);
    }

    @Override
    public void update(Observable o, Object arg) {
        String message = (String)arg;
        System.out.println(message);
        askForCommand();
    }

    public void addController(CatalogController catalogController){
        this.catalogController = catalogController;
    }
}
