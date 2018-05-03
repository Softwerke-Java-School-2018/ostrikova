package menu.client;

import exceptions.FieldNotFoundException;
import menu.BaseMenu;
import storage.ClientModelStorage;
import scanner.ReaderWriter;
import view.client.EditClientView;

import java.time.format.DateTimeParseException;

public class EditClientMenu implements BaseMenu {
    private EditClientView editClientView;

    public EditClientMenu(EditClientView editClientView){
        this.editClientView = editClientView;
    }

    @Override
    public void run() throws DateTimeParseException {

        ReaderWriter.getInstance().printLine("---Enter the id of editing client---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        ReaderWriter.getInstance().printLine("---Select the edit field---");
        showFields();

        try {
            String editField = ReaderWriter.getInstance().readLine();

            switch (editField) {
                case "1":
                    ReaderWriter.getInstance().printLine("---Enter new First Name---");
                    String newFirstName = ReaderWriter.getInstance().readLine();
                    ClientModelStorage.getInstance().editFirstName(id, newFirstName);
                    break;
                case "2":
                    ReaderWriter.getInstance().printLine("---Enter new Last Name---");
                    String newLastName = ReaderWriter.getInstance().readLine();
                    ClientModelStorage.getInstance().editLastName(id, newLastName);
                    break;
                case "3":
                    ReaderWriter.getInstance().printLine("---Enter new Birth Date---");
                    String newBirthDate = ReaderWriter.getInstance().readLine();
                    ClientModelStorage.getInstance().editBirthDate(id, newBirthDate);
                    break;
            }
        } catch (FieldNotFoundException e){
            editClientView.show("Client not found\n");
        }
    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Birth Date\n"
        );
    }

}
