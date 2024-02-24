package me.madcabbage.shopping_system;

import me.madcabbage.shopping_system.console_ui.ConsoleUI;
import me.madcabbage.shopping_system.util.FileDatabase;

public class Main {

    public static void main(String[] args) {
        runConsoleUI();
    }

    public static void runConsoleUI() {
        FileDatabase.initializeDirectories();
        ConsoleUI.show();
    }


}
