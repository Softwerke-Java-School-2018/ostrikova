package menu.device;

import menu.BaseMenu;
import model.Device;
import scanner.Scanner;

import java.util.Iterator;
import java.util.List;

public class DeleteDeviceMenu implements BaseMenu {
    List<Device> devices;

    public DeleteDeviceMenu(List<Device> devices) {
        this.devices = devices;
    }


    @Override
    public void run() {

        Scanner.getInstance().printLine("---Enter the id of the device you want to delete---");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        if (devices.size() > 0) {
                Iterator<Device> it = devices.iterator();
                while (it.hasNext()) {
                    if (it.next().getId() == id) {
                        it.remove();
                        break;
                    }
                }
        } else {
            Scanner.getInstance().printLine("List of devices is empty");
        }

    }
}
