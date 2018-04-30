package view.client;

import menu.StartMenu;
import scanner.ReaderWriter;
import view.BaseView;

public class DeleteClientView implements BaseView {
    private StartMenu startMenu;

    public DeleteClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Client deleted\n");
    }
}
