package menu.sort;

import menu.BaseMenu;
import model.Purchase;
import scanner.ReaderWriter;
import storage.PurchaseModelStorage;
import view.sort.SortPurchaseView;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortPurchaseMenu implements BaseMenu {

    private Stream<Purchase> purchaseListStream;
    private Stream<Purchase> sortedPurchaseStream;

    private SortPurchaseView sortPurchaseView;

    public SortPurchaseMenu(SortPurchaseView sortPurchaseView) {
        this.sortPurchaseView = sortPurchaseView;
    }

    @Override
    public void run() {

        this.purchaseListStream = PurchaseModelStorage
                .getInstance()
                .getStreamPurchases();

        ReaderWriter.getInstance().printLine("---Select the field you want to sort by---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                sortedPurchaseStream = purchaseListStream.sorted(Comparator.comparing(Purchase::getClientId));
                break;
            case "2":
                sortedPurchaseStream = purchaseListStream.sorted(Comparator.comparing(Purchase::getCurrentDate));
                break;
            case "3":
                sortedPurchaseStream = purchaseListStream.sorted(Comparator.comparing(Purchase::getTotalCost));
                break;
        }

        sortPurchaseView.printSortedPurchases(sortedPurchaseStream);
        sortPurchaseView.show("Sorted list\n");
    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. Id\n" +
                        "2. Date of purchase\n" +
                        "3. Total cost\n"
        );
    }

}
