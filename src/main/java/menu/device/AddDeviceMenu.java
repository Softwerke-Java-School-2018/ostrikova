package menu.device;

import menu.BaseMenu;
import model.Device;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class AddDeviceMenu extends BaseMenu {
    List<Device> devices;

    public AddDeviceMenu(List<Device> devices) {
        this.devices = devices;
    }


    @Override
    public void run() {

        System.out.println("Enter id");
        String stringId = in.nextLine();
        int id = Integer.parseInt(stringId);

        System.out.println("Enter manufacturer");
        String manufacturer = in.nextLine();

        System.out.println("Enter model");
        String model = in.nextLine();

        System.out.println("Enter type");
        String type = in.nextLine();

        System.out.println("Enter colour");
        String colour = in.nextLine();

        System.out.println("Enter production date in format YYYY-MM-DD");
        String prodDate = in.nextLine();
        LocalDate productionDate = LocalDate.parse(prodDate);

        System.out.println("Enter price");
        String stringPrice = in.nextLine();
        BigDecimal price = new BigDecimal(stringPrice);

        Device device = new Device.Builder(id)
                .setManufacturer(manufacturer)
                .setModel(model)
                .setType(type)
                .setColour(colour)
                .setProductionDate(productionDate)
                .setPrice(price)
                .build();

        devices.add(device);

    }

}
