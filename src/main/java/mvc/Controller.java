package mvc;

import java.time.format.DateTimeFormatter;

public abstract class Controller {

    public void showDeviceInputPattern(){
        System.out.println("Use this pattern for adding device");
        System.out.println("Manufacturer Model Type Colour Prod.Date(YYYY-MM-DD)");
    }

}
