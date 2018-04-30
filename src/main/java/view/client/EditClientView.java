package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class EditClientView implements BaseView {
    private StartMenu startMenu;

    public EditClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Client edited successfully\n");
    }
}
