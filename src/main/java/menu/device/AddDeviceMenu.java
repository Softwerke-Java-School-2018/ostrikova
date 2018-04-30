package menu.device;

import menu.BaseMenu;
import model.Device;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;

import java.math.BigDecimal;
import java.time.LocalDate;


public class AddDeviceMenu implements BaseMenu {

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("Enter manufacturer");
        String manufacturer = ReaderWriter.getInstance().readLine();

        ReaderWriter.getInstance().printLine("Enter model");
        String model = ReaderWriter.getInstance().readLine();

        ReaderWriter.getInstance().printLine("Enter type");
        String type = ReaderWriter.getInstance().readLine();

        ReaderWriter.getInstance().printLine("Enter colour");
        String colour = ReaderWriter.getInstance().readLine();

        ReaderWriter.getInstance().printLine("Enter production date in format YYYY-MM-DD");
        String prodDate = ReaderWriter.getInstance().readLine();
        LocalDate productionDate = LocalDate.parse(prodDate);

        ReaderWriter.getInstance().printLine("Enter price");
        String stringPrice = ReaderWriter.getInstance().readLine();
        BigDecimal price = new BigDecimal(stringPrice);

        Device device = new Device.Builder()
                .setManufacturer(manufacturer)
                .setModel(model)
                .setType(type)
                .setColour(colour)
                .setProductionDate(productionDate)
                .setPrice(price)
                .build();

        DeviceModelStorage.getInstance().addDevice(device);

    }

}
