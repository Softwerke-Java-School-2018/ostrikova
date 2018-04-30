package view.sort;

import menu.StartMenu;
import model.Client;
import model.Device;
import model.ModelStorage;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
