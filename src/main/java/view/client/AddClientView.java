package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class AddClientView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't add client: ";

    public AddClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message){
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }
}
