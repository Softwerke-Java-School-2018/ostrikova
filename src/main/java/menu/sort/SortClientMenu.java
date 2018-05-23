package menu.sort;

import menu.BaseMenu;
import model.Client;
import storage.ClientModelStorage;
import scanner.ReaderWriter;
import view.sort.SortClientView;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortClientMenu implements BaseMenu {

    private Stream<Client> clientListStream;
    private Stream<Client> sortedClientStream;

    private SortClientView sortClientView;

    public SortClientMenu(SortClientView sortClientView) {
        this.sortClientView = sortClientView;
    }

    @Override
    public void run() {

        this.clientListStream = ClientModelStorage
                .getInstance()
                .getStreamClients();

        ReaderWriter.getInstance().printLine("---Select the field you want to sort by---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                sortedClientStream = clientListStream.sorted(Comparator.comparing(Client::getFirstName));
                break;
            case "2":
                sortedClientStream = clientListStream.sorted(Comparator.comparing(Client::getLastName));
                break;
            case "3":
                sortedClientStream = clientListStream.sorted(Comparator.comparing(Client::getBirthDate));
                break;
            case "4":
                sortedClientStream = clientListStream.sorted(Comparator.comparing(Client::getClientId));
                break;
        }

        sortClientView.printSortedClients(sortedClientStream);
        sortClientView.show("Sorted list\n");
    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Date of birth\n" +
                        "4. Id\n"
        );
    }

}
