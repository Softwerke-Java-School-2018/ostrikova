package menu;

import menu.client.AddClientMenu;
import menu.client.DeleteClientMenu;
import menu.client.EditClientMenu;
import menu.device.AddDeviceMenu;
import menu.device.DeleteDeviceMenu;
import menu.device.EditDeviceMenu;
import menu.purchase.AddPurchaseMenu;
import menu.sort.ClientSortMenu;
import menu.sort.DeviceSortMenu;
import view.BaseView;
import view.client.AddClientView;
import view.client.DeleteClientView;
import view.client.EditClientView;
import view.device.AddDeviceView;
import view.device.DeleteDeviceView;
import view.device.EditDeviceView;
import view.purchase.AddPurchaseView;
import view.sort.ClientSortView;
import view.sort.DeviceSortView;

import java.util.List;

public class BootstrapMenu {

    private List<BaseMenu> entries;
    private List<BaseView> views;

    private StartMenu startMenu;

    public BootstrapMenu(List<BaseMenu> entries, List<BaseView> views, StartMenu startMenu){
        this.entries = entries;
        this.views = views;
        this.startMenu = startMenu;
    }

    public void fillMenu(){
        fillDeviceMenu();
        fillClientMenu();
        fillPurchaseMenu();
        fillSortMenu();
    }

    private void fillDeviceMenu(){
        entries.add(new AddDeviceMenu());
        views.add(new AddDeviceView(startMenu));

        entries.add(new DeleteDeviceMenu());
        views.add(new DeleteDeviceView(startMenu));

        entries.add(new EditDeviceMenu());
        views.add(new EditDeviceView(startMenu));
    }

    private void fillClientMenu(){
        entries.add(new AddClientMenu());
        views.add(new AddClientView(startMenu));

        entries.add(new DeleteClientMenu());
        views.add(new DeleteClientView(startMenu));

        entries.add(new EditClientMenu());
        views.add(new EditClientView(startMenu));
    }

    private void fillPurchaseMenu(){
        AddPurchaseView addPurchaseView = new AddPurchaseView(startMenu);
        views.add(addPurchaseView);
        entries.add(new AddPurchaseMenu(addPurchaseView));

    }

    private void fillSortMenu(){
        DeviceSortView deviceSortView = new DeviceSortView(startMenu);
        views.add(deviceSortView);
        entries.add(new DeviceSortMenu(deviceSortView));

        ClientSortView clientSortView = new ClientSortView(startMenu);
        views.add(clientSortView);
        entries.add(new ClientSortMenu(clientSortView));
    }
}
