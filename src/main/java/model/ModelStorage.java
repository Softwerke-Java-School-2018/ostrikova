package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModelStorage {
    private List<Device> devices;
    private List<Client> clients;
    private List<Purchase> purchases;

    public ModelStorage() {
        this.devices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.purchases = new ArrayList<>();
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public List<Device> getDevices() {
        return this.devices;
    }

    public Stream<Client> getStreamClients() {
        return clients.stream();
    }

    public Stream<Device> getStreamDevices() {
        return devices.stream();
    }

    public void addPurchase(int clientId, LocalDate today, int deviceId) {
        Client client = findClient(clientId);
        Device device = findDevice(deviceId);

        if (purchases.isEmpty()) {
            Purchase newPurchase = new Purchase(client, device, today);
            purchases.add(newPurchase);
        } else {

            boolean isFind = addIsFind(clientId, device, today);

            if (!isFind) {
                Purchase newPurchase = new Purchase(client, device, today);
                purchases.add(newPurchase);
            }
        }

    }

    private boolean addIsFind(int clientId, Device device, LocalDate today) {
        for (Purchase purchase : purchases) {
            if ((purchase.getClientId() == clientId) &&
                    (purchase.getCurrentDate().equals(today))) {
                addInDeviceModels(device, purchase);
                return true;
            }
        }
        return false;
    }

    private void addInDeviceModels(Device device, Purchase purchase) {
        ArrayList<DeviceModels> deviceModelsList = purchase
                .getStreamDeviceModelsList()
                .collect(Collectors.toCollection(ArrayList::new));

        if (deviceModelsList.isEmpty()) {
            purchase.addDeviceModelsList(device);
        } else {

            boolean isFind = increaseIsFind(deviceModelsList, device, purchase);

            if (!isFind) {
                purchase.addDeviceModelsList(device);
            }
        }
    }

    private boolean increaseIsFind(List<DeviceModels> deviceModelsList, Device device, Purchase purchase) {
        for (DeviceModels deviceModels : deviceModelsList) {
            if ((deviceModels.getManufacturer() == device.getManufacturer()) &&
                    (deviceModels.getModel() == device.getModel())) {
                purchase.setTotalCost(device.getPrice());
                deviceModels.setPrice(device.getPrice());
                deviceModels.increaseDeviceCount();
                return true;
            }
        }
        return false;
    }

    private Client findClient(int clientId) {
        Client rightClient = null;

        for (Client client : clients) {
            if (client.getClientId() == clientId) {
                rightClient = client;
                break;
            }
        }

        return rightClient;
    }

    private Device findDevice(int deviceId) {
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
