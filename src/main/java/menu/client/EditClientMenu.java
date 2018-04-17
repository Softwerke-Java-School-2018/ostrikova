package menu.client;

import menu.BaseMenu;
import model.Client;
import model.Device;

import java.util.List;
import java.util.ListIterator;

public class EditClientMenu extends BaseMenu {
    List<Client> clients;

    public EditClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        System.out.println("---Enter the id of editing client---");
        int id = Integer.parseInt(in.nextLine());

        System.out.println("---Select the edit field---");
        showFields();

        String editField = in.nextLine();

        switch (editField){
            case "1":
                editFirstName(id);
                break;
            case "2":
                editLastName(id);
                break;
            case "3":
                editBirthDate(id);
                break;
        }
    }

    private void showFields() {
        System.out.println(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Birth Date\n"
        );
    }

    private void editFirstName(int id){
        System.out.println("---Enter new First Name---");
        String newFirstName = in.nextLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setFirstName(newFirstName);
                break;
            }
        }
    }

    private void editLastName(int id){
        System.out.println("---Enter new Last Name---");
        String newLastName = in.nextLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setLastName(newLastName);
                break;
            }
        }
    }

    private void editBirthDate(int id){
        System.out.println("---Enter new Birth Date---");
        String newLastName = in.nextLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setBirthDate(newLastName);
                break;
            }
        }
    }
}
