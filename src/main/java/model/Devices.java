package model;

import java.util.ArrayList;
import java.util.List;

public class Devices {
    List<Device> devices = new ArrayList<>();

    public void addDevice(Device device){
        devices.add(device);
        System.out.println();
    }
}
