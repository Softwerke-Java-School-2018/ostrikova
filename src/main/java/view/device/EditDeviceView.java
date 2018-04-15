package view.device;

import menu.StartMenu;
import view.BaseView;

public class EditDeviceView extends BaseView {
    StartMenu startMenu;

    public EditDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Device edited successfully\n");
    }
}
