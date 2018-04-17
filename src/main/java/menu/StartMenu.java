package menu;

import menu.client.AddClientMenu;
import menu.client.DeleteClientMenu;
import menu.device.AddDeviceMenu;
import menu.device.DeleteDeviceMenu;
import menu.device.EditDeviceMenu;
import model.Client;
import model.Device;
import view.BaseView;
import view.ExitView;
import view.client.AddClientView;
import view.client.DeleteClientView;
import view.device.AddDeviceView;
import view.device.DeleteDeviceView;
import view.device.EditDeviceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartMenu {
    private boolean isExit = false;
    private Scanner in;
    private List<BaseMenu> entries = new ArrayList<>();
    private List<BaseView> views = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public StartMenu(){
        in = new Scanner(System.in);
        entries.add(new BaseMenu() {
            @Override
            public void run() {
                isExit = true;
            }
        });
        views.add(new ExitView(this));
    }

    public void start() {
        fillMenu();

        while (!isExit) {
            printMenu();

            String line = in.nextLine();
            int choice = Integer.parseInt(line);
            BaseMenu menu = entries.get(choice - 1);
            BaseView view = views.get(choice - 1);
            menu.run();
            view.show();

        }
    }

    private void fillMenu() {
        fillDeviceMenu(devices);
        fillClientMenu(clients);
    }

    private void fillDeviceMenu(List<Device> devices){
        entries.add(new AddDeviceMenu(devices));
        views.add(new AddDeviceView(this));

        entries.add(new DeleteDeviceMenu(devices));
        views.add(new DeleteDeviceView(this));

        entries.add(new EditDeviceMenu(devices));
        views.add(new EditDeviceView(this));
    }

    private void fillClientMenu(List<Client> clients){
        entries.add(new AddClientMenu(clients));
        views.add(new AddClientView(this));

        entries.add(new DeleteClientMenu(clients));
        views.add(new DeleteClientView(this));

    }

    private void printMenu() {
        System.out.println(
                "---Select the option---\n" +
                        "1. Exit\n" +
                        "2. Add new device\n" +
                        "3. Delete device by id\n" +
                        "4. Edit device\n" +
                        "5. Add new client\n" +
                        "6. Delete client by id\n"



        );
    }

}
