package menu.search;

import menu.BaseMenu;
import model.Purchase;
import scanner.ReaderWriter;
import storage.PurchaseModelStorage;
import view.search.SearchPurchaseView;

import java.time.LocalDate;
import java.util.stream.Stream;

public class SearchPurchaseMenu implements BaseMenu {
    private Stream<Purchase> foundPurchaseStream;

    private SearchPurchaseView searchPurchaseView;

    public SearchPurchaseMenu(SearchPurchaseView searchPurchaseView) {
        this.searchPurchaseView = searchPurchaseView;
    }

    @Override
    public void run() {
        ReaderWriter.getInstance().printLine("---Select the field you want to find for---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                ReaderWriter.getInstance().printLine("---Enter client id---");
                int clientId = Integer.valueOf(ReaderWriter.getInstance().readLine());
                foundPurchaseStream = PurchaseModelStorage.getInstance()
                        .findPurchaseStreamById(clientId);
                break;
            case "2":
                ReaderWriter.getInstance().printLine("---Enter date of purchase---");
                LocalDate purchaseDate = LocalDate.parse(ReaderWriter.getInstance().readLine());
                foundPurchaseStream = PurchaseModelStorage.getInstance()
                        .findPurchaseStreamByPurchaseDate(purchaseDate);
                break;
        }

        searchPurchaseView.printFoundPurchases(foundPurchaseStream);

    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. Id\n" +
                        "2. Date of purchase\n"
        );
    }
}
