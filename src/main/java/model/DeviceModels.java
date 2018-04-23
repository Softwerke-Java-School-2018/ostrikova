package model;

import java.math.BigDecimal;

public class DeviceModels {
    private String manufacturer;
    private String model;
    private BigDecimal price = new BigDecimal(0);
    private int deviceCount = 0;

    public DeviceModels(Device device){
        this.manufacturer = device.getManufacturer();
        this.model = device.getModel();
        this.price = this.price.add(device.getPrice());
    }

    public String getModel() {
        return model;
    }

    public void setPrice(BigDecimal price) {
        this.price = this.price.add(price);
    }

    public void increaseDeviceCount() {
        this.deviceCount +=1;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
