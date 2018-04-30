package menu.client;

import menu.BaseMenu;
import storage.ClientModelStorage;
import scanner.ReaderWriter;

public class DeleteClientMenu implements BaseMenu {

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of the client you want to delete---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        ClientModelStorage.getInstance().deleteClient(id);

    }

}
