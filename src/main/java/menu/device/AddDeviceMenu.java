package menu.device;

import menu.BaseMenu;
import model.Device;

import java.time.LocalDate;
import java.util.List;

public class AddDeviceMenu extends BaseMenu{
    List<Device> devices;

    public AddDeviceMenu(List<Device> devices){
        this.devices = devices;
    }


    @Override
    public void run() {
        String newDevice = in.nextLine();
        parseAddDevice(newDevice);

    }

    public void parseAddDevice(String newDevice){
        String[] addCmd = newDevice.split(" ");
        String manufacturer = addCmd[0];
        String model = addCmd[1];
        String type = addCmd[2];
        String colour = addCmd[3];
        String prodDate = addCmd[4];
        LocalDate productionDate = LocalDate.parse(prodDate);
        devices.add(new Device(manufacturer, model, type, colour, productionDate));
    }

}
