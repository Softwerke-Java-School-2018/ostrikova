package menu;

import java.util.Scanner;

public abstract class BaseMenu{
    protected Scanner in;

    public BaseMenu(){
        in = new Scanner(System.in);
    }

    public abstract void run();
}
