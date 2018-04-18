package view.device;

import menu.StartMenu;
import scanner.Scanner;
import view.BaseView;

public class EditDeviceView implements BaseView {
    StartMenu startMenu;

    public EditDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Device edited successfully\n");
    }
}
