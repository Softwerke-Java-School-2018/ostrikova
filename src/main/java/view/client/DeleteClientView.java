package view.client;

import menu.StartMenu;
import view.BaseView;

public class DeleteClientView extends BaseView {
    StartMenu startMenu;

    public DeleteClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        System.out.println("Client deleted\n");
    }
}
