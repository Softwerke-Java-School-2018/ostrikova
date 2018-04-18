package menu.client;

import menu.BaseMenu;
import model.Client;
import scanner.Scanner;

import java.time.LocalDate;
import java.util.List;

public class AddClientMenu implements BaseMenu {
    List<Client> clients;

    public AddClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("Enter id");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        Scanner.getInstance().printLine("Enter Last Name");
        String lastName = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter First Name");
        String firstName = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter Birth Date in format YYYY-MM-DD");
        String stringBirthDate = Scanner.getInstance().readLine();
        LocalDate birthDate = LocalDate.parse(stringBirthDate);

        Client client = new Client.Builder(id)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthDate(birthDate)
                .build();


        clients.add(client);

    }
}
