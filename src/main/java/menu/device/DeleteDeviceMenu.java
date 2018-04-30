package menu.device;

import menu.BaseMenu;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;

public class DeleteDeviceMenu implements BaseMenu {

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of the device you want to delete---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        DeviceModelStorage.getInstance().deleteDevice(id);

    }
}
