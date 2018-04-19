package menu.device;

import menu.BaseMenu;
import model.Device;
import model.ModelStorage;
import scanner.Scanner;

import java.util.List;
import java.util.ListIterator;


public class EditDeviceMenu implements BaseMenu {
    private List<Device> devices;

    public EditDeviceMenu(ModelStorage modelStorage) {
        this.devices = modelStorage.getDevices();
    }

    @Override
    public void run() {
        Scanner.getInstance().printLine("---Enter the id of editing device---");
        String stringId = Scanner.getInstance().readLine();
        int id = Integer.parseInt(stringId);

        Scanner.getInstance().printLine("---Select the edit field---");
        showFields();

        String editField = Scanner.getInstance().readLine();

        switch (editField){
            case "1":
                editManufacturer(id);
                break;
            case "2":
                editModel(id);
                break;
            case "3":
                editType(id);
                break;
            case "4":
                editColour(id);
                break;
            case "5":
                editProductionDate(id);
                break;
            case "6":
                editPrice(id);
                break;
        }


    }

    private void showFields() {
        Scanner.getInstance().printLine(
                "1. Manufacturer\n" +
                        "2. Model\n" +
                        "3. Type\n" +
                        "4. Colour\n" +
                        "5. Production date\n" +
                        "6. Price\n"

        );
    }

    private void editManufacturer(int id){
        Scanner.getInstance().printLine("---Enter new manufacturer---");
        String newManufacturer = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setManufacturer(newManufacturer);
                break;
            }
        }
    }

    private void editModel(int id){
        Scanner.getInstance().printLine("---Enter new model---");
        String newModel = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setModel(newModel);
                break;
            }
        }
    }

    private void editType(int id){
        Scanner.getInstance().printLine("---Enter new type---");
        String newType = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setType(newType);
                break;
            }
        }
    }

    private void editColour(int id){
        Scanner.getInstance().printLine("---Enter new colour---");
        String newColour = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setColour(newColour);
                break;
            }
        }
    }

    private void editProductionDate(int id){
        Scanner.getInstance().printLine("---Enter new production date---");
        String newProdDate = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setProductionDate(newProdDate);
                break;
            }
        }
    }

    private void editPrice(int id){
        Scanner.getInstance().printLine("---Enter new price---");
        String newPrice = Scanner.getInstance().readLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setPrice(newPrice);
                break;
            }
        }
    }
}
