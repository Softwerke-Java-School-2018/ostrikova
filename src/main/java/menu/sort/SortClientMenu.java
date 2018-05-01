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
                sortedClientStream = clientListStream.sorted(this.COMPARE_BY_FIRSTNAME);
                break;
            case "2":
                sortedClientStream = clientListStream.sorted(this.COMPARE_BY_LASTNAME);
                break;
            case "3":
                sortedClientStream = clientListStream.sorted(this.COMPARE_BY_BIRTHDATE);
                break;
            case "4":
                sortedClientStream = clientListStream.sorted(this.COMPARE_BY_ID);
                break;
        }

        sortClientView.printSortedClients(sortedClientStream);

    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Date of birth\n" +
                        "4. Id\n"
        );
    }

    private Comparator<Client> COMPARE_BY_ID = (one, other) -> {
        String oneId = String.valueOf(one.getClientId());
        String otherId = String.valueOf(other.getClientId());
        return oneId.compareTo(otherId);
    };

    private Comparator<Client> COMPARE_BY_FIRSTNAME = (one, other) -> {
        String oneFirstName = one.getFirstName();
        String otherFirstName = other.getFirstName();
        return oneFirstName.compareTo(otherFirstName);
    };

    private Comparator<Client> COMPARE_BY_LASTNAME = (one, other) -> {
        String oneLastName = one.getLastName();
        String otherLastName = other.getLastName();
        return oneLastName.compareTo(otherLastName);
    };

    private Comparator<Client> COMPARE_BY_BIRTHDATE = (one, other) -> {
        String oneBirthDate = one.toString();
        String otherBirthDate = other.getBirthDate().toString();
        return oneBirthDate.compareTo(otherBirthDate);
    };

}
