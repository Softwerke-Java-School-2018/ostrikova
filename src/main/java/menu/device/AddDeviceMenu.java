package menu.device;

import menu.BaseMenu;
import model.Device;
import model.ModelStorage;
import scanner.Scanner;

import java.math.BigDecimal;
import java.time.LocalDate;


public class AddDeviceMenu implements BaseMenu {
    private ModelStorage modelStorage;

    public AddDeviceMenu(ModelStorage modelStorage) {
        this.modelStorage = modelStorage;
    }


    @Override
    public void run() {

        Scanner.getInstance().printLine("Enter id");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        Scanner.getInstance().printLine("Enter manufacturer");
        String manufacturer = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter model");
        String model = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter type");
        String type = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter colour");
        String colour = Scanner.getInstance().readLine();

        Scanner.getInstance().printLine("Enter production date in format YYYY-MM-DD");
        String prodDate = Scanner.getInstance().readLine();
        LocalDate productionDate = LocalDate.parse(prodDate);

        Scanner.getInstance().printLine("Enter price");
        String stringPrice = Scanner.getInstance().readLine();
        BigDecimal price = new BigDecimal(stringPrice);

        Device device = new Device.Builder(id)
                .setManufacturer(manufacturer)
                .setModel(model)
                .setType(type)
                .setColour(colour)
                .setProductionDate(productionDate)
                .setPrice(price)
                .build();

        modelStorage.addDevice(device);

    }

}
