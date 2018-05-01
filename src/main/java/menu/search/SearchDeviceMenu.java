package menu.search;

import menu.BaseMenu;
import model.Device;
import scanner.ReaderWriter;
import storage.DeviceModelStorage;
import view.search.SearchDeviceView;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.stream.Stream;

public class SearchDeviceMenu implements BaseMenu {
    private Stream<Device> foundDeviceStream;

    private SearchDeviceView searchDeviceView;

    public SearchDeviceMenu(SearchDeviceView searchDeviceView) {
        this.searchDeviceView = searchDeviceView;
    }

    @Override
    public void run() {
        ReaderWriter.getInstance().printLine("---Select the field you want to find for---");
        showFields();

        String field = ReaderWriter.getInstance().readLine();

        switch (field) {
            case "1":
                ReaderWriter.getInstance().printLine("---Enter manufacturer---");
                String manufacturer = ReaderWriter.getInstance().readLine();
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByManufacturer(manufacturer);
                break;
            case "2":
                ReaderWriter.getInstance().printLine("---Enter model---");
                String model = ReaderWriter.getInstance().readLine();
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByModel(model);
                break;
            case "3":
                ReaderWriter.getInstance().printLine("---Enter type---");
                String type = ReaderWriter.getInstance().readLine();
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByType(type);
                break;
            case "4":
                ReaderWriter.getInstance().printLine("---Enter colour---");
                String colour = ReaderWriter.getInstance().readLine();
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByColour(colour);
                break;
            case "5":
                ReaderWriter.getInstance().printLine("---Enter production date---");
                LocalDate productionDate = LocalDate.parse(ReaderWriter.getInstance().readLine());
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByProdDate(productionDate);
                break;
            case "6":
                ReaderWriter.getInstance().printLine("---Enter price---");
                BigDecimal price = new BigDecimal(ReaderWriter.getInstance().readLine());
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamByPrice(price);
                break;
            case "7":
                ReaderWriter.getInstance().printLine("---Enter id---");
                int id = Integer.valueOf(ReaderWriter.getInstance().readLine());
                foundDeviceStream = DeviceModelStorage.getInstance()
                        .findDeviceStreamById(id);
                break;
        }

        searchDeviceView.printFoundDevices(foundDeviceStream);

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
