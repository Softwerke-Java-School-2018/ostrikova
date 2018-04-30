package scanner;

import model.Client;
import model.Device;

import java.util.stream.Stream;

public class ReaderWriter {

    private static ReaderWriter instance;
    private java.util.Scanner in;

    private ReaderWriter() {
        in = new java.util.Scanner(System.in);
    }

    public String readLine(){
        String line = in.nextLine();
        return line;
    }

    public void printLine(String line){
        System.out.println(line);
    }

    public void printLine(Device device){
        printLine(device.toString());
    }

    public void printLine(Client client){
        printLine(client.toString());
    }

    public static ReaderWriter getInstance() {
        if (instance == null) {
            instance = new ReaderWriter();
        }
        return instance;
    }
}
