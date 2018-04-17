package menu.client;

import menu.BaseMenu;
import model.Client;

import java.time.LocalDate;
import java.util.List;

public class AddClientMenu extends BaseMenu {
    List<Client> clients;

    public AddClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        System.out.println("Enter id");
        String stringId = in.nextLine();
        int id = Integer.parseInt(stringId);

        System.out.println("Enter Last Name");
        String lastName = in.nextLine();

        System.out.println("Enter First Name");
        String firstName = in.nextLine();

        System.out.println("Enter Birth Date in format YYYY-MM-DD");
        String stringBirthDate = in.nextLine();
        LocalDate birthDate = LocalDate.parse(stringBirthDate);

        clients.add(new Client(id, lastName, firstName, birthDate));

    }
}
