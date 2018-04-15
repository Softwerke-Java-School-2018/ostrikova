package menu.device;

import menu.BaseMenu;
import model.Device;

import java.util.List;
import java.util.ListIterator;

public class EditDeviceMenu extends BaseMenu {
    List<Device> devices;

    public EditDeviceMenu(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void run() {
        System.out.println("---Enter the id of editing device---");
        int id = Integer.parseInt(in.nextLine());

        System.out.println("---Select the edit field---");
        showFields();

        String editField = in.nextLine();

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
        System.out.println(
                "1. Manufacturer\n" +
                        "2. Model\n" +
                        "3. Type\n" +
                        "4. Colour\n" +
                        "5. Production date\n" +
                        "6. Price\n"

        );
    }

    private void editManufacturer(int id){
        System.out.println("---Enter new manufacturer---");
        String newManufacturer = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setManufacturer(newManufacturer);
                break;
            }
        }
    }

    private void editModel(int id){
        System.out.println("---Enter new model---");
        String newModel = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setModel(newModel);
                break;
            }
        }
    }

    private void editType(int id){
        System.out.println("---Enter new type---");
        String newType = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setType(newType);
                break;
            }
        }
    }

    private void editColour(int id){
        System.out.println("---Enter new colour---");
        String newColour = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setColour(newColour);
                break;
            }
        }
    }

    private void editProductionDate(int id){
        System.out.println("---Enter new production date---");
        String newProdDate = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setProductionDate(newProdDate);
                break;
            }
        }
    }

    private void editPrice(int id){
        System.out.println("---Enter new price---");
        String newPrice = in.nextLine();

        ListIterator<Device> it = devices.listIterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.previous().setPrice(newPrice);
                break;
            }
        }
    }
}
