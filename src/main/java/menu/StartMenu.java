package menu;

import model.ModelStorage;
import scanner.Scanner;
import view.BaseView;
import view.ExitView;

import java.util.ArrayList;
import java.util.List;

public class StartMenu {
    private boolean isExit = false;
    private List<BaseMenu> entries = new ArrayList<>();
    private List<BaseView> views = new ArrayList<>();
    private BootstrapMenu bootstrapMenu = new BootstrapMenu(entries, views, this);
    private ModelStorage modelStorage = new ModelStorage();

    public StartMenu(){
        entries.add(new BaseMenu() {
            @Override
            public void run() {
                isExit = true;
            }
        });
        views.add(new ExitView(this));
    }

    public void start() {
        bootstrapMenu.fillMenu(modelStorage);

        while (!isExit) {
            printMenu();

            String line = Scanner.getInstance().readLine();
            int choice = Integer.parseInt(line);
            BaseMenu menu = entries.get(choice - 1);
            BaseView view = views.get(choice - 1);
            menu.run();
            view.show();

        }
    }

    private void printMenu() {
        Scanner.getInstance().printLine(
                "---Select the option---\n" +
                        "1. Exit\n" +
                        "2. Add new device\n" +
                        "3. Delete device by id\n" +
                        "4. Edit device\n" +
                        "5. Add new client\n" +
                        "6. Delete client by id\n" +
                        "7. Edit client\n" +
                        "8. Add purchase\n"



        );
    }

}
