package view.device;

import menu.StartMenu;
import view.BaseView;

public class DeleteDeviceView extends BaseView{
    StartMenu startMenu;

    public DeleteDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Device deleted");
    }

}
