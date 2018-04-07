package model;

import java.time.LocalDate;

public class Device {
    private String manufacturer;
    private String model;
    private String type;
    private String colour;
    private LocalDate productionDate;

    public Device(String manufacturer, String model, String type, String colour, LocalDate productionDate){
        this.colour = colour;
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionDate = productionDate;
        this.type = type;
    }
}
