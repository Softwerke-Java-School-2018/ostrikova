package model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
