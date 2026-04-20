package presentation;

import application.*;

public class Main {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
