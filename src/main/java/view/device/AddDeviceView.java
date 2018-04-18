package view.device;

import menu.StartMenu;
import scanner.Scanner;
import view.BaseView;

public class AddDeviceView implements BaseView {
    StartMenu startMenu;

    public AddDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Device added\n");
    }

}
