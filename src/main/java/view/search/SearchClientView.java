package view.search;

import menu.StartMenu;
import model.Client;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class SearchClientView implements BaseView {
    private StartMenu startMenu;

    public SearchClientView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(message);
    }

    public void printFoundClients(Stream<Client> clientsStream) {
        ReaderWriter.getInstance().printLine("---Found client's list---");

        clientsStream.forEach(client -> ReaderWriter.getInstance().printLine(client));
    }
}
