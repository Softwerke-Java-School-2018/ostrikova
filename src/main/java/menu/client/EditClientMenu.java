package menu.client;

import menu.BaseMenu;
import storage.ClientModelStorage;
import scanner.ReaderWriter;

public class EditClientMenu implements BaseMenu {

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of editing client---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        ReaderWriter.getInstance().printLine("---Select the edit field---");
        showFields();

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
    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Birth Date\n"
        );
    }

}
