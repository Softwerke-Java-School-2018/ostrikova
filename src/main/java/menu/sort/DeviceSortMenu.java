package menu.sort;

import menu.BaseMenu;
import model.Device;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;
import view.sort.DeviceSortView;

import java.util.Comparator;
import java.util.stream.Stream;

public class DeviceSortMenu implements BaseMenu {

    private Stream<Device> deviceListStream;
    private Stream<Device> sortedDeviceStream;

    private DeviceSortView deviceSortView;

    public DeviceSortMenu(DeviceSortView deviceSortView) {
        this.deviceSortView = deviceSortView;
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
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_MANUFACTURER);
                break;
            case "2":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_MODEL);
                break;
            case "3":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_TYPE);
                break;
            case "4":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_COLOUR);
                break;
            case "5":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_PRODUCTIONDATE);
                break;
            case "6":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_PRICE);
                break;
            case "7":
                sortedDeviceStream = deviceListStream.sorted(this.COMPARE_BY_ID);
                break;
        }

        deviceSortView.printSortedDevices(sortedDeviceStream);

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

    private Comparator<Device> COMPARE_BY_ID = (one, other) -> {
        String oneId = String.valueOf(one.getId());
        String otherId = String.valueOf(other.getId());
        return oneId.compareTo(otherId);
    };

    private Comparator<Device> COMPARE_BY_MANUFACTURER = (one, other) -> {
        String oneManufacturer = one.getManufacturer();
        String otherManufacturer = other.getManufacturer();
        return oneManufacturer.compareTo(otherManufacturer);
    };

    private Comparator<Device> COMPARE_BY_MODEL = (one, other) -> {
        String oneModel = one.getModel();
        String otherModel = other.getModel();
        return oneModel.compareTo(otherModel);
    };

    private Comparator<Device> COMPARE_BY_COLOUR = (one, other) -> {
        String oneColour = one.getColour();
        String otherColour = other.getColour();
        return oneColour.compareTo(otherColour);
    };

    private Comparator<Device> COMPARE_BY_PRICE = (one, other) -> {
        String onePrice = one.getPrice().toString();
        String otherPrice = other.getPrice().toString();
        return onePrice.compareTo(otherPrice);
    };


    private Comparator<Device> COMPARE_BY_PRODUCTIONDATE = (one, other) -> {
        String oneProdDate = one.getProductionDate().toString();
        String otherProdDate = other.getProductionDate().toString();
        return oneProdDate.compareTo(otherProdDate);
    };

    private Comparator<Device> COMPARE_BY_TYPE = (one, other) -> {
        String oneType = one.getType();
        String otherType = other.getType();
        return oneType.compareTo(otherType);
    };
}
