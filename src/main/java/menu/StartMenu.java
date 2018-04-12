package menu;

import menu.device.AddDeviceMenu;
import model.Device;
import view.BaseView;
import view.ExitView;
import view.device.AddDeviceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartMenu {
    private boolean isExit = false;
    private Scanner in;
    private List<BaseMenu> entries = new ArrayList<>();
    private List<BaseView> views = new ArrayList<>();
    private List<Device> devices = new ArrayList<>();

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

    private void fillMenu() {

        entries.add(new AddDeviceMenu(devices));
        views.add(new AddDeviceView(this));




    }

    private void printMenu() {
        System.out.println(
                "---Select the option---\n" +
                        "1. Exit\n" +
                        "2. Add new device\n"


        );
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
}
