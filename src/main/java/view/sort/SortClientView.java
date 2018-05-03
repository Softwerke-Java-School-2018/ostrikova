package view.sort;

import menu.StartMenu;
import model.Client;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class SortClientView implements BaseView {
    private StartMenu startMenu;

    public SortClientView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(message);
    }

    public void printSortedClients(Stream<Client> clientsStream) {
        ReaderWriter.getInstance().printLine("---Sorted client's list---");

        clientsStream.forEach(client -> ReaderWriter.getInstance().printLine(client));
    }
}
