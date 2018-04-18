package menu.client;

import menu.BaseMenu;
import model.Client;
import scanner.Scanner;

import java.util.Iterator;
import java.util.List;

public class DeleteClientMenu implements BaseMenu {
    List<Client> clients;

    public DeleteClientMenu(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("---Enter the id of the client you want to delete---");
        String stringId = Scanner.getInstance().readLine();
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
            Scanner.getInstance().printLine("List of clients is empty");
        }

    }
}
