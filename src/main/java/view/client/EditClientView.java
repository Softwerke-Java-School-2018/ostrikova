package view.client;

import menu.StartMenu;
import scanner.Scanner;
import view.BaseView;

public class EditClientView implements BaseView {
    private StartMenu startMenu;

    public EditClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Client edited successfully\n");
    }
}
