package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class EditClientView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't edit client: ";

    public EditClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }
}
