package menu;

import menu.client.AddClientMenu;
import menu.client.DeleteClientMenu;
import menu.client.EditClientMenu;
import menu.device.AddDeviceMenu;
import menu.device.DeleteDeviceMenu;
import menu.device.EditDeviceMenu;
import menu.purchase.AddPurchaseMenu;
import model.ModelStorage;
import view.BaseView;
import view.client.AddClientView;
import view.client.DeleteClientView;
import view.client.EditClientView;
import view.device.AddDeviceView;
import view.device.DeleteDeviceView;
import view.device.EditDeviceView;
import view.purchase.AddPurchaseView;

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

    public void fillMenu(ModelStorage modelStorage){
        fillDeviceMenu(modelStorage);
        fillClientMenu(modelStorage);
        fillPurchaseMenu(modelStorage);
    }

    private void fillDeviceMenu(ModelStorage modelStorage){
        entries.add(new AddDeviceMenu(modelStorage));
        views.add(new AddDeviceView(startMenu));

        entries.add(new DeleteDeviceMenu(modelStorage));
        views.add(new DeleteDeviceView(startMenu));

        entries.add(new EditDeviceMenu(modelStorage));
        views.add(new EditDeviceView(startMenu));
    }

    private void fillClientMenu(ModelStorage modelStorage){
        entries.add(new AddClientMenu(modelStorage));
        views.add(new AddClientView(startMenu));

        entries.add(new DeleteClientMenu(modelStorage));
        views.add(new DeleteClientView(startMenu));

        entries.add(new EditClientMenu(modelStorage));
        views.add(new EditClientView(startMenu));
    }

    private void fillPurchaseMenu(ModelStorage modelStorage){
        AddPurchaseView addPurchaseView = new AddPurchaseView(startMenu);
        views.add(addPurchaseView);
        entries.add(new AddPurchaseMenu(modelStorage, addPurchaseView));

    }
}
