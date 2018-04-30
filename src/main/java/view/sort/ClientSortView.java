package view.sort;

import menu.StartMenu;
import model.Client;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class ClientSortView implements BaseView {
    private StartMenu startMenu;

    public ClientSortView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Sorted list\n");
    }

    public void printSortedClients(Stream<Client> clientsStream) {
        ReaderWriter.getInstance().printLine("---Sorted device's list---");

        clientsStream.forEach(client -> ReaderWriter.getInstance().printLine(client));
    }
}
