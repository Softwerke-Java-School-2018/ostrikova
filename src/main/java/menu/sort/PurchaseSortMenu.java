package menu.sort;

import menu.BaseMenu;
import model.Purchase;
import scanner.ReaderWriter;
import storage.PurchaseModelStorage;
import view.sort.PurchaseSortView;

import java.util.Comparator;
import java.util.stream.Stream;

public class PurchaseSortMenu implements BaseMenu {

    private Stream<Purchase> purchaseListStream;
    private Stream<Purchase> sortedPurchaseStream;

    private PurchaseSortView purchaseSortView;

    public PurchaseSortMenu(PurchaseSortView purchaseSortView) {
        this.purchaseSortView = purchaseSortView;
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
                sortedPurchaseStream = purchaseListStream.sorted(this.COMPARE_BY_ID);
                break;
            case "2":
                sortedPurchaseStream = purchaseListStream.sorted(this.COMPARE_BY_PURCHASEDATE);
                break;
            case "3":
                sortedPurchaseStream = purchaseListStream.sorted(this.COMPARE_BY_TOTALCOST);
                break;
        }

        purchaseSortView.printSortedPurchases(sortedPurchaseStream);

    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. Id\n" +
                        "2. Date of purchase\n" +
                        "3. Total cost\n"
        );
    }

    private Comparator<Purchase> COMPARE_BY_ID = (one, other) -> {
        String oneId = String.valueOf(one.getClientId());
        String otherId = String.valueOf(other.getClientId());
        return oneId.compareTo(otherId);
    };

    private Comparator<Purchase> COMPARE_BY_PURCHASEDATE = (one, other) -> {
        String oneId = String.valueOf(one.getCurrentDate());
        String otherId = String.valueOf(other.getCurrentDate());
        return oneId.compareTo(otherId);
    };

    private Comparator<Purchase> COMPARE_BY_TOTALCOST = (one, other) -> {
        String oneId = String.valueOf(one.getTotalCost());
        String otherId = String.valueOf(other.getTotalCost());
        return oneId.compareTo(otherId);
    };

}
