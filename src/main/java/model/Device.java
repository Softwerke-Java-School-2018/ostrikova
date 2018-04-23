package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class Device {
    private int id;
    private String manufacturer;
    private String model;
    private String type;
    private String colour;
    private LocalDate productionDate;
    private BigDecimal price;

    private Device(){

    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setProductionDate(String prodDate) {
        this.productionDate = LocalDate.parse(prodDate);
    }

    public void setPrice(String price) {
        this.price = new BigDecimal(price);
    }

    @Override
    public String toString(){
        return this.id + " " + this.manufacturer + " "
                + this.model + " " + this.type + " "
                + this.colour + " " + this.productionDate + " "
                + this.price;
    }

    public static Comparator<Device> COMPARE_BY_ID = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneId = String.valueOf(one.getId());
            String otherId = String.valueOf(other.getId());
            return oneId.compareTo(otherId);
        }
    };

    public static Comparator<Device> COMPARE_BY_MANUFACTURER = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneManufacturer = one.getManufacturer();
            String otherManufacturer = other.getManufacturer();
            return oneManufacturer.compareTo(otherManufacturer);
        }
    };

    public static Comparator<Device> COMPARE_BY_MODEL = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneModel = one.getModel();
            String otherModel = other.getModel();
            return oneModel.compareTo(otherModel);
        }
    };

    public static Comparator<Device> COMPARE_BY_COLOUR = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneColour = one.colour;
            String otherColour = other.colour;
            return oneColour.compareTo(otherColour);
        }
    };

    public static Comparator<Device> COMPARE_BY_PRICE = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String onePrice = one.price.toString();
            String otherPrice = other.price.toString();
            return onePrice.compareTo(otherPrice);
        }
    };

    public static Comparator<Device> COMPARE_BY_PRODUCTIONDATE = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneProdDate = one.productionDate.toString();
            String otherProdDate = other.productionDate.toString();
            return oneProdDate.compareTo(otherProdDate);
        }
    };

    public static Comparator<Device> COMPARE_BY_TYPE = new Comparator<Device>() {
        public int compare(Device one, Device other) {
            String oneType = one.type;
            String otherType = other.type;
            return oneType.compareTo(otherType);
        }
    };


    public static class Builder{
        private int id;
        private String manufacturer;
        private String model;
        private String type;
        private String colour;
        private LocalDate productionDate;
        private BigDecimal price;

        public Builder(int id){
            this.id = id;
        }

        public Builder setManufacturer(String manufacturer){
            this.manufacturer = manufacturer;
            return this;
        }

        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public Builder setType(String type){
            this.type = type;
            return this;
        }

        public Builder setColour(String colour){
            this.colour = colour;
            return this;
        }

        public Builder setProductionDate(LocalDate productionDate){
            this.productionDate = productionDate;
            return this;
        }

        public Builder setPrice(BigDecimal price){
            this.price = price;
            return this;
        }

        public Device build(){
            Device device = new Device();
            device.id = this.id;
            device.price = this.price;
            device.colour = this.colour;
            device.manufacturer = this.manufacturer;
            device.model = this.model;
            device.type = this.type;
            device.productionDate = this.productionDate;

            return device;
        }


    }
}
