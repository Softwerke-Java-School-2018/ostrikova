package model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Device {
    private static int id = 0;

    private int deviceId;

    private String manufacturer;
    private String model;
    private String type;
    private String colour;

    private LocalDate productionDate;

    private BigDecimal price;

    private Device(Builder builder){
        this.deviceId = id++;
        this.price = builder.price;
        this.colour = builder.colour;
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.type = builder.type;
        this.productionDate = builder.productionDate;

    }

    public int getId() {
        return deviceId;
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

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public LocalDate getProductionDate() {
        return productionDate;
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
        return this.deviceId + " " + this.manufacturer + " "
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

        public Builder(){

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
            return new Device(this);
        }


    }
}
