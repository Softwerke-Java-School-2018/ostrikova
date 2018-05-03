package menu.device;

import menu.BaseMenu;
import model.Device;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;
import view.device.AddDeviceView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class AddDeviceMenu implements BaseMenu {
    private AddDeviceView addDeviceView;

    public AddDeviceMenu(AddDeviceView addDeviceView){
        this.addDeviceView = addDeviceView;
    }

    @Override
    public void run() throws DateTimeParseException {

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
