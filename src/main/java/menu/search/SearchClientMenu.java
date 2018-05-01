package menu.search;

import menu.BaseMenu;
import model.Client;
import scanner.ReaderWriter;
import storage.ClientModelStorage;
import view.search.SearchClientView;

import java.time.LocalDate;
import java.util.stream.Stream;

public class SearchClientMenu implements BaseMenu {
    private Stream<Client> foundClientStream;

    private SearchClientView searchClientView;

    public SearchClientMenu(SearchClientView searchClientView) {
        this.searchClientView = searchClientView;
    }

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Select the field you want to find for---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                ReaderWriter.getInstance().printLine("---Enter first name---");
                String firstName = ReaderWriter.getInstance().readLine();
                foundClientStream = ClientModelStorage.getInstance()
                        .findClientStreamByFirstName(firstName);
                break;
            case "2":
                ReaderWriter.getInstance().printLine("---Enter last name---");
                String lastName = ReaderWriter.getInstance().readLine();
                foundClientStream = ClientModelStorage.getInstance()
                        .findClientStreamByLastName(lastName);
                break;
            case "3":
                ReaderWriter.getInstance().printLine("---Enter date of birth---");
                LocalDate birthDate = LocalDate.parse(ReaderWriter.getInstance().readLine());
                foundClientStream = ClientModelStorage.getInstance()
                        .findClientStreamByBirthDate(birthDate);
                break;
            case "4":
                ReaderWriter.getInstance().printLine("---Enter id---");
                int id = Integer.parseInt(ReaderWriter.getInstance().readLine());
                foundClientStream = ClientModelStorage.getInstance()
                        .findClientStreamById(id);
                break;
        }

        searchClientView.printFoundClients(foundClientStream);
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
