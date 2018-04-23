package view.sort;

import menu.StartMenu;
import model.Client;
import scanner.Scanner;
import view.BaseView;

import java.util.List;

public class ClientSortView implements BaseView {
    private StartMenu startMenu;

    public ClientSortView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Sorted list\n");
    }

    public void printSortedClients(List<Client> clients){
        Scanner.getInstance().printLine("---Sorted device's list---");

        for (Client client: clients) {
            Scanner.getInstance().printLine(client);
        }
    }
}
