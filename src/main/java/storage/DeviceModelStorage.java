package storage;

import model.Device;
import scanner.ReaderWriter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class DeviceModelStorage {

    private static DeviceModelStorage instance;
    private List<Device> devices;

    private DeviceModelStorage() {
        this.devices = new ArrayList<>();
    }

    public static DeviceModelStorage getInstance() {
        if (instance == null) {
            instance = new DeviceModelStorage();
        }
        return instance;
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public Stream<Device> getStreamDevices() {
        return devices.stream();
    }

    public void deleteDevice(int id) {

        if (!devices.isEmpty()) {

            Iterator<Device> it = devices.iterator();

            while (it.hasNext()) {
                if (it.next().getId() == id) {
                    it.remove();
                    break;
                }
            }

        } else {
            ReaderWriter.getInstance().printLine("List of devices is empty");
        }

    }

    public void editManufacturer(int id, String newManufacturer) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setManufacturer(newManufacturer);
                break;
            }
        }

    }

    public void editModel(int id, String newModel) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setModel(newModel);
                break;
            }
        }

    }

    public void editType(int id, String newType) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setType(newType);
                break;
            }
        }

    }

    public void editColour(int id, String newColour) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setColour(newColour);
                break;
            }
        }

    }

    public void editProductionDate(int id, String newProdDate) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setProductionDate(newProdDate);
                break;
            }
        }

    }

    public void editPrice(int id, String newPrice) {

        ListIterator<Device> it = devices.listIterator();

        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setPrice(newPrice);
                break;
            }
        }

    }

    public Device findDevice(int deviceId) {

        Device rightDevice = null;

        for (Device device : devices) {
            if (device.getId() == deviceId) {
                rightDevice = device;
                break;
            }
        }

        return rightDevice;
    }

}

