package view;

import menu.StartMenu;
import scanner.Scanner;

public class ExitView implements BaseView {
    StartMenu startMenu;

    public ExitView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Successful exit");
    }
}
