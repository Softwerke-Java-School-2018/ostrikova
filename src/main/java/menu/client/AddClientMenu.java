package menu.client;

import menu.BaseMenu;
import model.Client;
import storage.ClientModelStorage;
import scanner.ReaderWriter;

import java.time.LocalDate;

public class AddClientMenu implements BaseMenu {

    @Override
    public void run() {

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
