package menu.device;

import menu.BaseMenu;
import model.Device;

import java.util.Iterator;
import java.util.List;

public class DeleteDeviceMenu extends BaseMenu {
    List<Device> devices;

    public DeleteDeviceMenu(List<Device> devices) {
        this.devices = devices;
    }


    @Override
    public void run() {

        System.out.println("Enter the id of the device you want to delete");
        String stringId = in.nextLine();
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
            System.out.println("List of devices is empty");
        }

    }
}
