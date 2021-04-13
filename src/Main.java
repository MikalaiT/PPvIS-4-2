import view.MainApplication;

public class Main {
    static String a, b, c;

    public static void main(String[] args) {
        a = (b = (c = "c") + "b") + "a";
        MainApplication.doThing(args);
    }
}
