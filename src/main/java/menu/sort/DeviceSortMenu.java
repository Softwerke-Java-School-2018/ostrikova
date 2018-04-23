package menu.sort;

import menu.BaseMenu;
import model.Device;
import model.ModelStorage;
import scanner.Scanner;
import view.sort.DeviceSortView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class DeviceSortMenu implements BaseMenu {
    private ModelStorage modelStorage;
    private ArrayList<Device> deviceList;
    private DeviceSortView deviceSortView;

    public DeviceSortMenu(ModelStorage modelStorage, DeviceSortView deviceSortView) {
        this.deviceSortView = deviceSortView;
        this.modelStorage = modelStorage;
    }

    @Override
    public void run() {
        this.deviceList = modelStorage
                .getStreamDevices()
                .collect(Collectors.toCollection(ArrayList::new));

        Scanner.getInstance().printLine("---Select the field you want to sort by---");
        showFields();

        String field = Scanner.getInstance().readLine();

        switch (field) {
            case "1":
                Collections.sort(deviceList, Device.COMPARE_BY_MANUFACTURER);
                break;
            case "2":
                Collections.sort(deviceList, Device.COMPARE_BY_MODEL);
                break;
            case "3":
                Collections.sort(deviceList, Device.COMPARE_BY_TYPE);
                break;
            case "4":
                Collections.sort(deviceList, Device.COMPARE_BY_COLOUR);
                break;
            case "5":
                Collections.sort(deviceList, Device.COMPARE_BY_PRODUCTIONDATE);
                break;
            case "6":
                Collections.sort(deviceList, Device.COMPARE_BY_PRICE);
                break;
            case "7":
                Collections.sort(deviceList, Device.COMPARE_BY_ID);
                break;
        }

        deviceSortView.printSortedDevices(deviceList);

    }

    private void showFields() {
        Scanner.getInstance().printLine(
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
