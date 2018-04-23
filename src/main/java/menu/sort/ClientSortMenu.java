package menu.sort;

import menu.BaseMenu;
import model.Client;
import model.ModelStorage;
import scanner.Scanner;
import view.sort.ClientSortView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class ClientSortMenu implements BaseMenu {
    private ModelStorage modelStorage;
    private ArrayList<Client> clientList;
    private ClientSortView clientSortView;

    public ClientSortMenu(ModelStorage modelStorage, ClientSortView clientSortView) {
        this.clientSortView = clientSortView;
        this.modelStorage = modelStorage;
    }

    @Override
    public void run() {
        this.clientList = modelStorage
                .getStreamClients()
                .collect(Collectors.toCollection(ArrayList::new));

        Scanner.getInstance().printLine("---Select the field you want to sort by---");
        showFields();

        String field = Scanner.getInstance().readLine();

        switch (field) {
            case "1":
                Collections.sort(clientList, Client.COMPARE_BY_FIRSTNAME);
                break;
            case "2":
                Collections.sort(clientList, Client.COMPARE_BY_LASTNAME);
                break;
            case "3":
                Collections.sort(clientList, Client.COMPARE_BY_BIRTHDATE);
                break;
            case "4":
                Collections.sort(clientList, Client.COMPARE_BY_ID);
                break;
        }

        clientSortView.printSortedClients(clientList);

    }

    private void showFields() {
        Scanner.getInstance().printLine(
                "1. First Name\n" +
                        "2. Last Name\n" +
                        "3. Date of birth\n" +
                        "4. Id\n"
        );
    }
}
