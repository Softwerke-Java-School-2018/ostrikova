package menu.client;

import menu.BaseMenu;
import model.Client;

import java.util.Iterator;
import java.util.List;

public class DeleteClientMenu extends BaseMenu {
    List<Client> clients;

    public DeleteClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        System.out.println("---Enter the id of the client you want to delete---");
        String stringId = in.nextLine();
        int id = Integer.parseInt(stringId);

        if (clients.size() > 0) {
            Iterator<Client> it = clients.iterator();
            while (it.hasNext()) {
                if (it.next().getClientId() == id) {
                    it.remove();
                    break;
                }
            }
        } else {
            System.out.println("List of clients is empty");
        }

    }
}
