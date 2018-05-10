package menu;

import scanner.ReaderWriter;
import view.BaseView;
import view.ExitView;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class StartMenu {

    private boolean isExit = false;

    private List<BaseMenu> entries = new ArrayList<>();
    private List<BaseView> views = new ArrayList<>();

    private BootstrapMenu bootstrapMenu = new BootstrapMenu(entries, views, this);

    public StartMenu() {
        ExitView exitView = new ExitView(this);
        entries.add(() -> {
            isExit = true;
            exitView.show("Successful exit");
        });
        views.add(exitView);
    }

    /** Starts the right menu depending on the number
     * entered from the console
     * @throws DateTimeParseException if person entered an incorrect date
     */
    public void start() {

        bootstrapMenu.fillMenu();

        while (!isExit) {
            printMenu();

            String line = ReaderWriter.getInstance().readLine();
            int choice = Integer.parseInt(line);

            BaseMenu menu = entries.get(choice - 1);
            BaseView view = views.get(choice - 1);

            try {
                menu.run();
            } catch (DateTimeParseException e){
                view.show("Invalid Date format\n");
            }
        }
    }

    private void printMenu() {
        ReaderWriter.getInstance().printLine(
                "---Select the option---\n" +
                        "1. Exit\n" +
                        "2. Add new device\n" +
                        "3. Delete device by id\n" +
                        "4. Edit device\n" +
                        "5. Add new client\n" +
                        "6. Delete client by id\n" +
                        "7. Edit client\n" +
                        "8. Add purchase\n" +
                        "9. Sort devices\n" +
                        "10. Sort clients\n" +
                        "11. Sort purchases\n" +
                        "12. Search client\n" +
                        "13. Search device\n" +
                        "14. Search purchase\n"
        );
    }

}
