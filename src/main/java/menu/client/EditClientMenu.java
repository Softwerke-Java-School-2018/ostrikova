package menu.client;

import menu.BaseMenu;
import model.Client;
import model.ModelStorage;
import scanner.Scanner;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

public class EditClientMenu implements BaseMenu {
    private List<Client> clients;

    public EditClientMenu(ModelStorage modelStorage) {
        this.clients = modelStorage.getClients();
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("---Enter the id of editing client---");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        Scanner.getInstance().printLine("---Select the edit field---");
        showFields();

        String editField = Scanner.getInstance().readLine();

        switch (editField) {
            case "1":
                Scanner.getInstance().printLine("---Enter new First Name---");
                String newFirstName = Scanner.getInstance().readLine();
                editFirstName(id, newFirstName);
                break;
            case "2":
                Scanner.getInstance().printLine("---Enter new Last Name---");
                String newLastName = Scanner.getInstance().readLine();
                editLastName(id, newLastName);
                break;
            case "3":
                Scanner.getInstance().printLine("---Enter new Birth Date---");
                String newBirthDate = Scanner.getInstance().readLine();
                editBirthDate(id, newBirthDate);
                break;
        }
    }

    private void showFields() {
        Scanner.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Birth Date\n"
        );
    }

    public void editFirstName(int id, String newFirstName) {

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setFirstName(newFirstName);
                break;
            }
        }

    }

    private void editLastName(int id, String newLastName) {

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setLastName(newLastName);
                break;
            }
        }

    }

    private void editBirthDate(int id, String newBirthDate) {


        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setBirthDate(newBirthDate);
                break;
            }
        }

    }
}
