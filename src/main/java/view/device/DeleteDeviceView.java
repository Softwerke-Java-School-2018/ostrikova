package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class DeleteDeviceView implements BaseView{
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't delete device: ";

    public DeleteDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }

}
