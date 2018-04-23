package menu.purchase;

import menu.BaseMenu;
import model.Client;
import model.Device;
import model.ModelStorage;
import scanner.Scanner;
import view.purchase.AddPurchaseView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddPurchaseMenu implements BaseMenu {
    private ModelStorage modelStorage;
    private AddPurchaseView addPurchaseView;

    public AddPurchaseMenu(ModelStorage modelStorage, AddPurchaseView addPurchaseView) {
        this.modelStorage = modelStorage;
        this.addPurchaseView = addPurchaseView;
    }

    @Override
    public void run() {
        printClients();
        Scanner.getInstance().printLine("---Enter client's id---");
        String stringClientId = Scanner.getInstance().readLine();
        int clientId = Integer.parseInt(stringClientId);

        printDevices();
        Scanner.getInstance().printLine("---Enter device's id---");
        String stringDeviceId = Scanner.getInstance().readLine();
        int deviceId = Integer.parseInt(stringDeviceId);

        LocalDate today = LocalDate.now();

        modelStorage.addPurchase(clientId, today, deviceId);
    }

    private void printClients() {
        ArrayList<Client> clients = modelStorage
                .getStreamClients()
                .collect(Collectors.toCollection(ArrayList::new));

        addPurchaseView.printClients(clients);
    }

    private void printDevices(){
        ArrayList<Device> devices = modelStorage
                .getStreamDevices()
                .collect(Collectors.toCollection(ArrayList::new));

        addPurchaseView.printDevice(devices);
    }
}
