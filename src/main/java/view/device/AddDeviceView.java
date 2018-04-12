package view.device;

import menu.StartMenu;
import view.BaseView;

public class AddDeviceView extends BaseView {
    StartMenu startMenu;

    public AddDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Device added");
    }

}
