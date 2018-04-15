package view;

import menu.StartMenu;

public class ExitView extends BaseView {
    StartMenu startMenu;

    public ExitView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Successful exit");
    }
}
