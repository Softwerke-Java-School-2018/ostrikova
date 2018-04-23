package view.sort;

import menu.StartMenu;
import model.Device;
import scanner.Scanner;
import view.BaseView;

import java.util.List;

public class DeviceSortView implements BaseView {
    private StartMenu startMenu;

    public DeviceSortView(StartMenu startMenu){
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        Scanner.getInstance().printLine("Sorted list\n");
    }

    public void printSortedDevices(List<Device> devices){
        Scanner.getInstance().printLine("---Sorted device's list---");

        for (Device device: devices) {
            Scanner.getInstance().printLine(device);
        }
    }
}
