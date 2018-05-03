package view;

import menu.StartMenu;
import scanner.ReaderWriter;

public class ExitView implements BaseView {
    StartMenu startMenu;

    public ExitView(StartMenu startMenu) {
        this.startMenu = startMenu;
    }

    @Override
    public void show(String message) {
        ReaderWriter.getInstance().printLine(message);
    }
}
