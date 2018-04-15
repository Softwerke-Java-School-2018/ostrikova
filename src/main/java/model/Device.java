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

    public Device(int id, String manufacturer, String model, String type,
                  String colour, LocalDate productionDate, BigDecimal price){
        this.id = id;
        this.colour = colour;
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionDate = productionDate;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
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
}
