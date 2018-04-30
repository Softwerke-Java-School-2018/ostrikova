package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class EditDeviceView implements BaseView {
    private StartMenu startMenu;

    public EditDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Device edited successfully\n");
    }
}
