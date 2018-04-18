package scanner;

public class Scanner {

    private static Scanner instance;
    private java.util.Scanner in;

    private Scanner() {
        in = new java.util.Scanner(System.in);
    }

    public String readLine(){
        String line = in.nextLine();
        return line;
    }

    public void printLine(String line){
        System.out.println(line);
    }

    public static Scanner getInstance() {
        if (instance == null) {
            instance = new Scanner();
        }
        return instance;
    }
}
