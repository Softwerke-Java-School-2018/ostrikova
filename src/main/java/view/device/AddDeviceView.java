package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class AddDeviceView implements BaseView {
    private StartMenu startMenu;

    public AddDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Device added\n");
    }

}
