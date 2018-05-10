package storage;

import exceptions.FieldNotFoundException;
import model.Client;
import model.Device;
import model.Purchase;
import model.DeviceStorage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PurchaseModelStorage {

    private static PurchaseModelStorage instance;
    private List<Purchase> purchases;

    private PurchaseModelStorage() {
        this.purchases = new ArrayList<>();
    }

    public static PurchaseModelStorage getInstance() {
        if (instance == null) {
            instance = new PurchaseModelStorage();
        }
        return instance;
    }

    public Stream<Purchase> getStreamPurchases() {
        return purchases.stream();
    }

    /** Add purchase in purchase's list
     * If the customer is already in the purchase's list
     * then the device'll add in the device's list for
     * a specific customer
     *
     * @see PurchaseModelStorage#addInDeviceModels(Device, Purchase)
     * @param clientId client's id for adding a purchase
     * @param deviceId device's id for adding a purchase
     * @throws FieldNotFoundException if client or device wasn't find
     */
    public void addPurchase(int clientId, int deviceId) throws FieldNotFoundException {

        Client client = ClientModelStorage.getInstance().findClient(clientId);
        Device device = DeviceModelStorage.getInstance().findDevice(deviceId);

        if (purchases.isEmpty()) {

            Purchase newPurchase = new Purchase(client, device);
            purchases.add(newPurchase);

        } else {

            boolean isFind = addIsFind(clientId, device);

            if (!isFind) {
                Purchase newPurchase = new Purchase(client, device);
                purchases.add(newPurchase);
            }

        }

    }

    private boolean addIsFind(int clientId, Device device) {

        for (Purchase purchase : purchases) {

            if ((purchase.getClientId() == clientId) &&
                    (purchase.getCurrentDate().equals(LocalDate.now()))) {

                addInDeviceModels(device, purchase);
                return true;

            }

        }

        return false;
    }

    private void addInDeviceModels(Device device, Purchase purchase) {

        ArrayList<DeviceStorage> deviceStorageList = purchase
                .getStreamDeviceModelsList()
                .collect(Collectors.toCollection(ArrayList::new));

        if (deviceStorageList.isEmpty()) {

            purchase.addDeviceModelsList(device);

        } else {

            boolean isFind = increaseIsFind(deviceStorageList, device, purchase);

            if (!isFind) {
                purchase.addDeviceModelsList(device);
            }
        }
    }

    private boolean increaseIsFind(List<DeviceStorage> deviceStorageList, Device device, Purchase purchase) {

        for (DeviceStorage deviceStorage : deviceStorageList) {

            if ((deviceStorage.getManufacturer() == device.getManufacturer()) &&
                    (deviceStorage.getModel() == device.getModel())) {

                purchase.setTotalCost(device.getPrice());
                deviceStorage.setPrice(device.getPrice());
                deviceStorage.increaseDeviceCount();
                return true;

            }
        }

        return false;
    }

    public Stream<Purchase> findPurchaseStreamById(int id) {
        return purchases.stream()
                .filter(purchases -> purchases.getClientId() == id);
    }

    public Stream<Purchase> findPurchaseStreamByPurchaseDate(LocalDate purchaseDate) {
        return purchases.stream()
                .filter(purchases -> purchaseDate.equals(purchases.getCurrentDate()));
    }

}
