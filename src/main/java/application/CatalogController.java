package application;

import mvc.Controller;

import java.time.LocalDate;
import java.util.Scanner;

public class CatalogController extends Controller {
    private CatalogView catalogView;
    private Catalog catalog;
    Scanner in = new Scanner(System.in);

    public CatalogController(Catalog catalog, CatalogView catalogView){
        this.catalog = catalog;
        this.catalogView = catalogView;
    }


    public void execute(String command){
        switch (command){
            case "1":
                showDeviceInputPattern();
                String newDevice = in.nextLine();
                parseAddDevice(newDevice);
                break;
        }
    }

    public void parseAddDevice(String newDevice){
        String[] addCmd = newDevice.split(" ");
        String manufacturer = addCmd[0];
        String model = addCmd[1];
        String type = addCmd[2];
        String colour = addCmd[3];
        String prodDate = addCmd[4];
        LocalDate productionDate = LocalDate.parse(prodDate);
        catalog.addDevice(manufacturer, model, type, colour, productionDate);
    }

}
