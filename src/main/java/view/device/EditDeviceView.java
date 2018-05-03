package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class EditDeviceView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't edit device: ";

    public EditDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }
}
