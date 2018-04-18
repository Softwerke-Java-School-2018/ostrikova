package view.client;

import menu.StartMenu;
import scanner.Scanner;
import view.BaseView;

public class AddClientView implements BaseView {
    StartMenu startMenu;

    public AddClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Client added\n");
    }
}
