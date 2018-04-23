package view.client;

import menu.StartMenu;
import menu.purchase.AddPurchaseMenu;
import scanner.Scanner;
import view.BaseView;
import view.purchase.AddPurchaseView;

public class AddClientView implements BaseView {
    private StartMenu startMenu;

    public AddClientView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Client added\n");
    }
}
