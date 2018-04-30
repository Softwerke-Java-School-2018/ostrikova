package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class AddClientView implements BaseView {
    private StartMenu startMenu;

    public AddClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Client added\n");
    }
}
