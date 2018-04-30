package menu.purchase;

import menu.BaseMenu;
import model.Client;
import model.Device;
import storage.ClientModelStorage;
import storage.DeviceModelStorage;
import storage.PurchaseModelStorage;
import scanner.ReaderWriter;
import view.purchase.AddPurchaseView;

import java.util.stream.Stream;

public class AddPurchaseMenu implements BaseMenu {

    private AddPurchaseView addPurchaseView;

    public AddPurchaseMenu(AddPurchaseView addPurchaseView) {
        this.addPurchaseView = addPurchaseView;
    }

    @Override
    public void run() {

        printClients();
        ReaderWriter.getInstance().printLine("---Enter client's id---");
        String stringClientId = ReaderWriter.getInstance().readLine();
        int clientId = Integer.parseInt(stringClientId);

        printDevices();
        ReaderWriter.getInstance().printLine("---Enter device's id---");
        String stringDeviceId = ReaderWriter.getInstance().readLine();
        int deviceId = Integer.parseInt(stringDeviceId);

        PurchaseModelStorage.getInstance().addPurchase(clientId, deviceId);
    }

    private void printClients() {
        Stream<Client> clientsStream = ClientModelStorage
                .getInstance()
                .getStreamClients();

        addPurchaseView.printClients(clientsStream);
    }

    private void printDevices(){
        Stream<Device> devicesStream = DeviceModelStorage
                .getInstance()
                .getStreamDevices();

        addPurchaseView.printDevice(devicesStream);
    }
}
