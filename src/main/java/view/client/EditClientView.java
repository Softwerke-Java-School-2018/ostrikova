package view.client;

import menu.StartMenu;
import view.BaseView;

public class EditClientView extends BaseView {
    StartMenu startMenu;

    public EditClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Client edited successfully\n");
    }
}
