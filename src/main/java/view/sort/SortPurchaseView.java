package view.sort;

import menu.StartMenu;
import model.Purchase;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class SortPurchaseView implements BaseView {
    private StartMenu startMenu;

    public SortPurchaseView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Sorted list\n");
    }

    public void printSortedPurchases(Stream<Purchase> purchasesStream) {
        ReaderWriter.getInstance().printLine("---Sorted purchase's list---");

        purchasesStream.forEach(purchase -> ReaderWriter.getInstance().printLine(purchase));
    }
}
