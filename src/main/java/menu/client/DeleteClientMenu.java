package menu.client;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
import menu.BaseMenu;
import storage.ClientModelStorage;
import scanner.ReaderWriter;
import view.client.DeleteClientView;

public class DeleteClientMenu implements BaseMenu {
    private DeleteClientView deleteClientView;

    public DeleteClientMenu(DeleteClientView deleteClientView){
        this.deleteClientView = deleteClientView;
    }

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of the client you want to delete---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        try {
            ClientModelStorage.getInstance().deleteClient(id);
        } catch (FieldNotFoundException e){
            deleteClientView.show("Client not found\n");
        } catch (EmptyListException e){
            deleteClientView.show(e.getMessage());
        }

    }

}
