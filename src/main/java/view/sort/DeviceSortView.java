package view.sort;

import menu.StartMenu;
import model.Device;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeviceSortView implements BaseView {
    private StartMenu startMenu;

    public DeviceSortView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Sorted list\n");
    }

    public void printSortedDevices(Stream<Device> devicesStream) {
        ReaderWriter.getInstance().printLine("---Sorted device's list---");

        devicesStream.forEach(device -> ReaderWriter.getInstance().printLine(device));
    }
}
