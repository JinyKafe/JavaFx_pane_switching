package com.hexenwerk.javafx.paneswitching;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp
{

    // 1. runs Java application. Neither SpringContext nor JavaFx context is initialized in this stage
    public static void main(String[] args)
    {
        // 2. Start JavaFX application in another Thread (by calling com.sun.javafx.application.LauncherImpl#run())
        Application.launch(SpringbootJavaFxApplication.class, args);
    }
}
