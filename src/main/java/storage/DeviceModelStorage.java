package storage;

import model.Client;
import model.Device;
import scanner.ReaderWriter;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public Stream<Device> findDeviceStreamById(int id){
        return devices.stream()
                .filter(clients -> clients.getId() == id);
    }

    public Stream<Device> findDeviceStreamByManufacturer(String manufacturer){
        return devices.stream()
                .filter(clients -> manufacturer.equalsIgnoreCase(clients.getManufacturer()));
    }

    public Stream<Device> findDeviceStreamByModel(String model){
        return devices.stream()
                .filter(clients -> model.equalsIgnoreCase(clients.getModel()));
    }

    public Stream<Device> findDeviceStreamByColour(String colour){
        return devices.stream()
                .filter(clients -> colour.equalsIgnoreCase(clients.getColour()));
    }

    public Stream<Device> findDeviceStreamByType(String type){
        return devices.stream()
                .filter(clients -> type.equalsIgnoreCase(clients.getType()));
    }

    public Stream<Device> findDeviceStreamByProdDate(LocalDate prodDate){
        return devices.stream()
                .filter(clients -> prodDate.equals(clients.getProductionDate()));
    }

    public Stream<Device> findDeviceStreamByPrice(BigDecimal price){
        return devices.stream()
                .filter(clients -> price.compareTo(clients.getPrice()) == 0);
    }

}

