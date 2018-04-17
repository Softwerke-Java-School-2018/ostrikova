package view.client;

import menu.StartMenu;
import view.BaseView;

public class AddClientView extends BaseView {
    StartMenu startMenu;

    public AddClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Client added\n");
    }
}
