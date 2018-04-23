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
    private List<DeviceModels> deviceModels = new ArrayList<>();

    public Purchase(Client client, Device device, LocalDate today){
        this.clientId = client.getClientId();
        this.totalCost = this.totalCost.add(device.getPrice());
        this.currentDate = today;
        DeviceModels newDeviceModels = new DeviceModels(device);
        deviceModels.add(newDeviceModels);
    }

    public void setTotalCost(BigDecimal price) {
        this.totalCost = this.totalCost.add(price);
    }

    public int getClientId(){
        return clientId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public Stream<DeviceModels> getStreamDeviceModelsList(){
        return deviceModels.stream();
    }

    public void addDeviceModelsList(Device device){
        DeviceModels newDeviceModels = new DeviceModels(device);
        this.deviceModels.add(newDeviceModels);
    }
}
