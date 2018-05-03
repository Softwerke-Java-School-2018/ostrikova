package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class AddDeviceView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't add device: ";

    public AddDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }

}
