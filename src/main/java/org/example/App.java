package org.example;

import org.example.controllers.Controller;
import org.example.controllers.DynamicController;
import org.example.controllers.MainController;
import org.example.controllers.RecursiveController;

public class App {
    public static void main(String[] args) {
        final Controller dynamicController = new DynamicController();
        final Controller recursiveController = new RecursiveController();

        MainController mainController = new MainController(dynamicController, recursiveController);
        mainController.start();
    }
}
