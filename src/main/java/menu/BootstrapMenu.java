package menu;

import menu.client.AddClientMenu;
import menu.client.DeleteClientMenu;
import menu.client.EditClientMenu;
import menu.device.AddDeviceMenu;
import menu.device.DeleteDeviceMenu;
import menu.device.EditDeviceMenu;
import menu.purchase.AddPurchaseMenu;
import menu.search.SearchClientMenu;
import menu.search.SearchDeviceMenu;
import menu.search.SearchPurchaseMenu;
import menu.sort.SortClientMenu;
import menu.sort.SortDeviceMenu;
import menu.sort.SortPurchaseMenu;
import view.BaseView;
import view.client.AddClientView;
import view.client.DeleteClientView;
import view.client.EditClientView;
import view.device.AddDeviceView;
import view.device.DeleteDeviceView;
import view.device.EditDeviceView;
import view.purchase.AddPurchaseView;
import view.search.SearchClientView;
import view.search.SearchDeviceView;
import view.search.SearchPurchaseView;
import view.sort.SortClientView;
import view.sort.SortDeviceView;
import view.sort.SortPurchaseView;

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
        fillSearchMenu();
    }

    private void fillDeviceMenu(){
        AddDeviceView addDeviceView = new AddDeviceView(startMenu);
        views.add(addDeviceView);
        entries.add(new AddDeviceMenu(addDeviceView));

        DeleteDeviceView deleteDeviceView = new DeleteDeviceView(startMenu);
        views.add(deleteDeviceView);
        entries.add(new DeleteDeviceMenu(deleteDeviceView));

        EditDeviceView editDeviceView = new EditDeviceView(startMenu);
        views.add(editDeviceView);
        entries.add(new EditDeviceMenu(editDeviceView));
    }

    private void fillClientMenu(){
        AddClientView addClientView = new AddClientView(startMenu);
        views.add(addClientView);
        entries.add(new AddClientMenu(addClientView));

        DeleteClientView deleteClientView = new DeleteClientView(startMenu);
        views.add(deleteClientView);
        entries.add(new DeleteClientMenu(deleteClientView));

        EditClientView editClientView = new EditClientView(startMenu);
        views.add(editClientView);
        entries.add(new EditClientMenu(editClientView));
    }

    private void fillPurchaseMenu(){
        AddPurchaseView addPurchaseView = new AddPurchaseView(startMenu);
        views.add(addPurchaseView);
        entries.add(new AddPurchaseMenu(addPurchaseView));

    }

    private void fillSortMenu(){
        SortDeviceView sortDeviceView = new SortDeviceView(startMenu);
        views.add(sortDeviceView);
        entries.add(new SortDeviceMenu(sortDeviceView));

        SortClientView sortClientView = new SortClientView(startMenu);
        views.add(sortClientView);
        entries.add(new SortClientMenu(sortClientView));

        SortPurchaseView sortPurchaseView = new SortPurchaseView(startMenu);
        views.add(sortPurchaseView);
        entries.add(new SortPurchaseMenu(sortPurchaseView));
    }

    private void fillSearchMenu(){
        SearchClientView searchClientView = new SearchClientView(startMenu);
        views.add(searchClientView);
        entries.add(new SearchClientMenu(searchClientView));

        SearchDeviceView searchDeviceView = new SearchDeviceView(startMenu);
        views.add(searchDeviceView);
        entries.add(new SearchDeviceMenu(searchDeviceView));

        SearchPurchaseView searchPurchaseView = new SearchPurchaseView(startMenu);
        views.add(searchPurchaseView);
        entries.add(new SearchPurchaseMenu(searchPurchaseView));
    }
}
