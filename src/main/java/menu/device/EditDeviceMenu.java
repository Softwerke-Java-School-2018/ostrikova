package menu.device;

import menu.BaseMenu;
import storage.DeviceModelStorage;
import scanner.ReaderWriter;

public class EditDeviceMenu implements BaseMenu {

    @Override
    public void run() {

        ReaderWriter.getInstance().printLine("---Enter the id of editing device---");
        String stringId = ReaderWriter.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        ReaderWriter.getInstance().printLine("---Select the edit field---");
        showFields();

        String editField = ReaderWriter.getInstance().readLine();

        switch (editField){
            case "1":
                ReaderWriter.getInstance().printLine("---Enter new manufacturer---");
                String newManufacturer = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editManufacturer(id, newManufacturer);
                break;
            case "2":
                ReaderWriter.getInstance().printLine("---Enter new model---");
                String newModel = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editModel(id, newModel);
                break;
            case "3":
                ReaderWriter.getInstance().printLine("---Enter new type---");
                String newType = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editType(id, newType);
                break;
            case "4":
                ReaderWriter.getInstance().printLine("---Enter new colour---");
                String newColour = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editColour(id, newColour);
                break;
            case "5":
                ReaderWriter.getInstance().printLine("---Enter new production date---");
                String newProdDate = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editProductionDate(id, newProdDate);
                break;
            case "6":
                ReaderWriter.getInstance().printLine("---Enter new price---");
                String newPrice = ReaderWriter.getInstance().readLine();
                DeviceModelStorage.getInstance().editPrice(id, newPrice);
                break;
        }


    }

    private void showFields() {
        ReaderWriter.getInstance().printLine(
                "1. Manufacturer\n" +
                        "2. Model\n" +
                        "3. Type\n" +
                        "4. Colour\n" +
                        "5. Production date\n" +
                        "6. Price\n"

        );
    }

}
