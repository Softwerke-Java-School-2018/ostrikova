package view.search;

import menu.StartMenu;
import model.Device;
import scanner.ReaderWriter;
import view.BaseView;

import java.util.stream.Stream;

public class SearchDeviceView implements BaseView {
    private StartMenu startMenu;

    public SearchDeviceView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show() {
        ReaderWriter.getInstance().printLine("Search was successful\n");
    }

    public void printFoundDevices(Stream<Device> devicesStream) {
        ReaderWriter.getInstance().printLine("---Found device's list---");

        devicesStream.forEach(device -> ReaderWriter.getInstance().printLine(device));
    }
}
