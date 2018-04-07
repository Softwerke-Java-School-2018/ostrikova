package application;

import model.Device;
import model.Devices;
import mvc.Model;

import java.time.LocalDate;

public class Catalog extends Model {
    private Devices devices = new Devices();

    public void changed(String message) {
        setChanged();
        notifyObservers(message);
    }

    public void addDevice(String manufacturer, String model, String type, String colour, LocalDate prodDate){
        devices.addDevice(new Device(manufacturer, model, type, colour, prodDate));
        changed("Device added");
    }

}
