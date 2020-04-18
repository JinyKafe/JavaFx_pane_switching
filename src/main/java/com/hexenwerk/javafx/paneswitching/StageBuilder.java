package com.hexenwerk.javafx.paneswitching;

import com.hexenwerk.javafx.paneswitching.fx.MainController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class StageBuilder implements ApplicationListener<StageReadyEvent>
{
    @Value("${spring.application.demo.greeting}")
    private String greeting;

    @Autowired
    @Qualifier("resourceBundleEN")
    ResourceBundle resourceBundleEN;

    @Autowired
    @Qualifier("resourceBundleCZ")
    ResourceBundle resourceBundleCZ;

    @Autowired
    private FxWeaver fxWeaver;

    private static Language APP_LANGUAGE = Language.EN;

    private static Stage PRIMARY_STAGE;

    @Override
    public void onApplicationEvent(StageReadyEvent event)
    {
        PRIMARY_STAGE = event.stage;
        PRIMARY_STAGE.setTitle(greeting);
        Scene scene = new Scene(getViewByController(MainController.class), 400, 300);
        scene.getStylesheets().setAll(getClass().getResource("vista.css").toExternalForm());
        showPrimaryScene(scene);
    }

    public <C, V extends Node> V getViewByController(Class<C> controllerClass)
    {
        return getViewByController(controllerClass, getAppLanguage());
    }

    public <C, V extends Node> V getViewByController(Class<C> controllerClass, Language language)
    {
        ResourceBundle resourceBundle = language == Language.EN ? this.resourceBundleEN : resourceBundleCZ;
        return getViewByController(controllerClass, resourceBundle);
    }

    private <C, V extends Node> V getViewByController(Class<C> controllerClass, ResourceBundle resourceBundleEN)
    {
        V view = fxWeaver.loadView(controllerClass, resourceBundleEN);
        return Optional.of(view).orElseThrow(() -> new RuntimeException("Unable to load view for controller " + controllerClass));
    }

    public static Language getAppLanguage()
    {
        return APP_LANGUAGE;
    }

    public static void setAppLanguage(Language appLanguage)
    {
        APP_LANGUAGE = appLanguage;
    }

    public static Stage getPrimaryStage()
    {
        return PRIMARY_STAGE;
    }

    public void showPrimaryScene(Scene scene)
    {
        PRIMARY_STAGE.setScene(scene);
        PRIMARY_STAGE.show();
    }
}
