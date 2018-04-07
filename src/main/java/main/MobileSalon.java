package main;

import application.Catalog;
import application.CatalogController;
import application.CatalogView;

public class MobileSalon {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        CatalogView catalogView = new CatalogView();
        CatalogController catalogController = new CatalogController(catalog, catalogView);
        catalog.addObserver(catalogView);
        catalogView.addController(catalogController);
        catalogView.askForCommand();
    }
}
