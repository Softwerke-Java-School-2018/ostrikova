package menu.client;

import menu.BaseMenu;
import model.Client;
import model.ModelStorage;
import scanner.Scanner;

import java.util.Iterator;
import java.util.List;

public class DeleteClientMenu implements BaseMenu {
    private List<Client> clients;

    public DeleteClientMenu(ModelStorage modelStorage) {
        this.clients = modelStorage.getClients();
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("---Enter the id of the client you want to delete---");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        if (clients.size() > 0) {
            deleteClient(id);
        } else {
            Scanner.getInstance().printLine("Can't be removed. List of clients is empty");
        }

    }

    public void deleteClient(int id){
        Iterator<Client> it = clients.iterator();
        while (it.hasNext()) {
            if (it.next().getClientId() == id) {
                it.remove();
                break;
            }
        }
    }
}
