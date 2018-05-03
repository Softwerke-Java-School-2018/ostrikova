package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class DeleteClientView implements BaseView {
    private StartMenu startMenu;
    private String exceptionMessage = "Couldn't delete client: ";

    public DeleteClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(exceptionMessage + message);
    }
}
