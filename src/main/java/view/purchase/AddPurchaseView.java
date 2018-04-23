package view.purchase;

import menu.StartMenu;
import model.Client;
import model.Device;
import scanner.Scanner;
import view.BaseView;

import java.util.ArrayList;

public class AddPurchaseView implements BaseView {
    private StartMenu startMenu;

    public AddPurchaseView(StartMenu startMenu){
        this.startMenu = startMenu;
    }


    @Override
    public void show() {
        Scanner.getInstance().printLine("Purchase added\n");
    }

    public void printClients(ArrayList<Client> clients){
        Scanner.getInstance().printLine("---Client's list---");

        for (Client client : clients) {
            Scanner.getInstance().printLine(client);
        }
    }

    public void printDevice(ArrayList<Device> devices){
        Scanner.getInstance().printLine("---Device's list---");

        for (Device device: devices) {
            Scanner.getInstance().printLine(device);
        }
    }
}
