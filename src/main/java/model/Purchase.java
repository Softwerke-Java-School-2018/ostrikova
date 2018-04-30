package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Purchase {
    private int clientId;
    private LocalDate currentDate;
    private BigDecimal totalCost = new BigDecimal(0);
    private List<DeviceStorage> deviceModels = new ArrayList<>();

    public Purchase(Client client, Device device) {
        this.clientId = client.getClientId();
        this.totalCost = this.totalCost.add(device.getPrice());
        this.currentDate = LocalDate.now();
        DeviceStorage newDeviceStorage = new DeviceStorage(device);
        deviceModels.add(newDeviceStorage);
    }

    public int getClientId() {
        return clientId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal price) {
        this.totalCost = this.totalCost.add(price);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public Stream<DeviceStorage> getStreamDeviceModelsList() {
        return deviceModels.stream();
    }

    public void addDeviceModelsList(Device device) {
        DeviceStorage newDeviceStorage = new DeviceStorage(device);
        this.deviceModels.add(newDeviceStorage);
    }


    @Override
    public String toString() {
        return this.clientId
                + " " + this.currentDate
                + " " + this.totalCost;
    }
}
