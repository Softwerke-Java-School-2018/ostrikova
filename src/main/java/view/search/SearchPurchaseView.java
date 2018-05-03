package view.search;

import menu.StartMenu;
import model.Purchase;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class SearchPurchaseView implements BaseView {
    private StartMenu startMenu;

    public SearchPurchaseView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(message);
    }

    public void printFoundPurchases(Stream<Purchase> purchasesStream) {
        ReaderWriter.getInstance().printLine("---Found purchase's list---");

        purchasesStream.forEach(purchase -> ReaderWriter.getInstance().printLine(purchase));
    }
}
