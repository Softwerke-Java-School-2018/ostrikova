package menu.client;

import menu.BaseMenu;
import model.Client;
import storage.ClientModelStorage;
import scanner.ReaderWriter;
import view.client.AddClientView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AddClientMenu implements BaseMenu {

    private AddClientView addClientView;

    public AddClientMenu(AddClientView addClientView) {
        this.addClientView = addClientView;
    }

    @Override
    public void run() throws DateTimeParseException {

        ReaderWriter.getInstance().printLine("Enter Last Name");
        String lastName = ReaderWriter.getInstance().readLine();

        ReaderWriter.getInstance().printLine("Enter First Name");
        String firstName = ReaderWriter.getInstance().readLine();


        ReaderWriter.getInstance().printLine("Enter Birth Date in format YYYY-MM-DD");
        String stringBirthDate = ReaderWriter.getInstance().readLine();
        LocalDate birthDate = LocalDate.parse(stringBirthDate);

        Client client = new Client.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthDate(birthDate)
                .build();

        ClientModelStorage.getInstance().addClient(client);

    }
}
