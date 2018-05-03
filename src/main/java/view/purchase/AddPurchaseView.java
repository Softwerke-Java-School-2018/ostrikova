package view.purchase;

import menu.StartMenu;
import model.Client;
import model.Device;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.ArrayList;
import java.util.stream.Stream;

public class AddPurchaseView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't add purchase: ";

    public AddPurchaseView(StartMenu startMenu){
        this.startMenu = startMenu;
    }


    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }

    public void printClients(Stream<Client> clientsStream){
        ReaderWriter.getInstance().printLine("---Client's list---");

        clientsStream.forEach(client -> ReaderWriter.getInstance().printLine(client));
    }

    public void printDevice(Stream<Device> devicesStream){
        ReaderWriter.getInstance().printLine("---Device's list---");

        devicesStream.forEach(client -> ReaderWriter.getInstance().printLine(client));
    }
}
