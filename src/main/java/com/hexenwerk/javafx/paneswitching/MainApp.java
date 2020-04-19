package com.hexenwerk.javafx.paneswitching;

import com.hexenwerk.javafx.paneswitching.fx.service.SceneBuilder;
import com.hexenwerk.javafx.paneswitching.fx.type.LanguageType;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class MainApp implements ApplicationListener<StageReadyEvent>
{
    @Value("${spring.application.demo.greeting}")
    private String greeting;

    @Autowired
    private SceneBuilder sceneBuilder;

    public static LanguageType LANGUAGE = LanguageType.EN;

    public static Stage PRIMARY_STAGE;

    // 1. runs Java application. Neither SpringContext nor JavaFx context is initialized in this stage
    public static void main(String[] args)
    {
        // 2. Start JavaFX application in another Thread (by calling com.sun.javafx.application.LauncherImpl#run())
        Application.launch(SpringbootJavaFxApplication.class, args);
    }

    // 6. callback method. Catching event produced by SpringBootJavaFxApplication#start() method, once the initialization of Spring context, JavaFx context and FxWeaver context is done
    @Override
    public void onApplicationEvent(StageReadyEvent event)
    {
        PRIMARY_STAGE = event.stage;
        PRIMARY_STAGE.setTitle(greeting);
        PRIMARY_STAGE.setScene(sceneBuilder.initMainScene());
        PRIMARY_STAGE.show();
    }

    public static void toggleLanguage()
    {
        LANGUAGE = LANGUAGE == LanguageType.EN ? LanguageType.CZ : LanguageType.EN;
    }
}
