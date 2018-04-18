package menu.client;

import menu.BaseMenu;
import model.Client;
import scanner.Scanner;

import java.util.List;
import java.util.ListIterator;

public class EditClientMenu implements BaseMenu {
    List<Client> clients;

    public EditClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("---Enter the id of editing client---");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        Scanner.getInstance().printLine("---Select the edit field---");
        showFields();

        String editField = Scanner.getInstance().readLine();

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
        Scanner.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Birth Date\n"
        );
    }

    private void editFirstName(int id){
        Scanner.getInstance().printLine("---Enter new First Name---");
        String newFirstName = Scanner.getInstance().readLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setFirstName(newFirstName);
                break;
            }
        }
    }

    private void editLastName(int id){
        Scanner.getInstance().printLine("---Enter new Last Name---");
        String newLastName = Scanner.getInstance().readLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setLastName(newLastName);
                break;
            }
        }
    }

    private void editBirthDate(int id){
        Scanner.getInstance().printLine("---Enter new Birth Date---");
        String newLastName = Scanner.getInstance().readLine();

        ListIterator<Client> it = clients.listIterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.previous().setBirthDate(newLastName);
                break;
            }
        }
    }
}
