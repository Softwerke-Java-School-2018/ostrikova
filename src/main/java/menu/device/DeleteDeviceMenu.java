package menu.device;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
import menu.BaseMenu;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;
import view.device.DeleteDeviceView;

public class DeleteDeviceMenu implements BaseMenu {
    private DeleteDeviceView deleteDeviceView;

    public DeleteDeviceMenu(DeleteDeviceView deleteDeviceView) {
        this.deleteDeviceView = deleteDeviceView;
    }

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of the device you want to delete---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        try {
            DeviceModelStorage.getInstance().deleteDevice(id);
        } catch (
                FieldNotFoundException e) {
            deleteDeviceView.show("Device not found\n");
        } catch (EmptyListException e) {
            deleteDeviceView.show(e.getMessage());
        }

    }
}
