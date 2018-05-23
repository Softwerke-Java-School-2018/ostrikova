package menu.sort;

import menu.BaseMenu;
import model.Device;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;
import view.sort.SortDeviceView;

import java.util.Comparator;
import java.util.stream.Stream;

public class SortDeviceMenu implements BaseMenu {

    private Stream<Device> deviceListStream;
    private Stream<Device> sortedDeviceStream;

    private SortDeviceView sortDeviceView;

    public SortDeviceMenu(SortDeviceView sortDeviceView) {
        this.sortDeviceView = sortDeviceView;
    }

    @Override
    public void run() {

        this.deviceListStream = DeviceModelStorage
                .getInstance()
                .getStreamDevices();

        ReaderWriter.getInstance().printLine("---Select the field you want to sort by---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getManufacturer));
                break;
            case "2":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getModel));
                break;
            case "3":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getType));
                break;
            case "4":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getColour));
                break;
            case "5":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getProductionDate));
                break;
            case "6":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getPrice));
                break;
            case "7":
                sortedDeviceStream = deviceListStream.sorted(Comparator.comparing(Device::getId));
                break;
        }

        sortDeviceView.printSortedDevices(sortedDeviceStream);
        sortDeviceView.show("Sorted list\n");

    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. Manufacturer\n" +
                        "2. Model\n" +
                        "3. Type\n" +
                        "4. Colour\n" +
                        "5. Production date\n" +
                        "6. Price\n" +
                        "7. Id\n"
        );
    }

}
