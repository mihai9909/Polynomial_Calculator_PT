import controller.Controller;
import view.View;

public class Main {

    public static void main(String[] args) {
        Controller c = new Controller();
        new View(c);
    }
}
