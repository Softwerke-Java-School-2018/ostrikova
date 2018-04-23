package view.client;

import menu.StartMenu;
import scanner.Scanner;
import view.BaseView;

public class DeleteClientView implements BaseView {
    private StartMenu startMenu;

    public DeleteClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Client deleted\n");
    }
}
