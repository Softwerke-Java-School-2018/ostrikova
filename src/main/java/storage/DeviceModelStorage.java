package storage;

import exceptions.EmptyListException;
import exceptions.FieldNotFoundException;
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

    public void deleteDevice(int id) throws FieldNotFoundException, EmptyListException {
        boolean isFind = false;

        if (!devices.isEmpty()) {

            Iterator<Device> it = devices.iterator();

            while (it.hasNext()) {
                if (it.next().getId() == id) {
                    it.remove();
                    isFind = true;
                }
            }

            if (!isFind) {
                throw new FieldNotFoundException();
            }

        } else {
            throw new EmptyListException("List is empty\n");
        }

    }

    public void editManufacturer(int id, String newManufacturer) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setManufacturer(newManufacturer);
                isFind = true;
            }
        }

        if(!isFind){
            throw new FieldNotFoundException();
        }
    }

    public void editModel(int id, String newModel) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setModel(newModel);
                isFind = true;
            }
        }

        if (!isFind) {
            throw new FieldNotFoundException();
        }
    }

    public void editType(int id, String newType) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setType(newType);
                isFind = true;
            }
        }

        if (!isFind) {
            throw new FieldNotFoundException();
        }
    }

    public void editColour(int id, String newColour) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setColour(newColour);
                isFind = true;
            }
        }

        if (!isFind) {
            throw new FieldNotFoundException();
        }
    }

    public void editProductionDate(int id, String newProdDate) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setProductionDate(newProdDate);
                isFind = true;
            }
        }

        if (!isFind) {
            throw new FieldNotFoundException();
        }
    }

    public void editPrice(int id, String newPrice) throws FieldNotFoundException {
        boolean isFind = false;

        for(Device device: devices){
            if (device.getId() == id){
                device.setPrice(newPrice);
                isFind = true;
            }
        }

        if (!isFind) {
            throw new FieldNotFoundException();
        }
    }

    public Device findDevice(int deviceId) throws FieldNotFoundException{
        boolean isFind = false;

        Device rightDevice = null;

        for (Device device : devices) {
            if (device.getId() == deviceId) {
                rightDevice = device;
                isFind = true;
            }
        }

        if(!isFind){
            throw new FieldNotFoundException();
        }

        return rightDevice;
    }

    public Stream<Device> findDeviceStreamById(int id) {
        return devices.stream()
                .filter(clients -> clients.getId() == id);
    }

    public Stream<Device> findDeviceStreamByManufacturer(String manufacturer) {
        return devices.stream()
                .filter(clients -> manufacturer.equalsIgnoreCase(clients.getManufacturer()));
    }

    public Stream<Device> findDeviceStreamByModel(String model) {
        return devices.stream()
                .filter(clients -> model.equalsIgnoreCase(clients.getModel()));
    }

    public Stream<Device> findDeviceStreamByColour(String colour) {
        return devices.stream()
                .filter(clients -> colour.equalsIgnoreCase(clients.getColour()));
    }

    public Stream<Device> findDeviceStreamByType(String type) {
        return devices.stream()
                .filter(clients -> type.equalsIgnoreCase(clients.getType()));
    }

    public Stream<Device> findDeviceStreamByProdDate(LocalDate prodDate) {
        return devices.stream()
                .filter(clients -> prodDate.equals(clients.getProductionDate()));
    }

    public Stream<Device> findDeviceStreamByPrice(BigDecimal price) {
        return devices.stream()
                .filter(clients -> price.compareTo(clients.getPrice()) == 0);
    }

}

