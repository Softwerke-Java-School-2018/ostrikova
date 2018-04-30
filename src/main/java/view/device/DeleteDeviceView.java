package view.device;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class DeleteDeviceView implements BaseView{
    private StartMenu startMenu;

    public DeleteDeviceView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Device deleted\n");
    }

}
