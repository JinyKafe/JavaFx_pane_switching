package com.hexenwerk.javafx.paneswitching.fx.service;

import com.hexenwerk.javafx.paneswitching.fx.type.LanguageType;
import com.hexenwerk.javafx.paneswitching.MainApp;
import javafx.scene.Node;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.ResourceBundle;

@Component
public class StageBuilder
{
    @Autowired
    @Qualifier("resourceBundleEN")
    ResourceBundle resourceBundleEN;

    @Autowired
    @Qualifier("resourceBundleCZ")
    ResourceBundle resourceBundleCZ;

    @Autowired
    private FxWeaver fxWeaver;

    public <C, V extends Node> V getViewByController(Class<C> controllerClass)
    {
        return getViewByController(controllerClass, MainApp.LANGUAGE);
    }

    public <C, V extends Node> V getViewByController(Class<C> controllerClass, LanguageType language)
    {
        return getViewByController(controllerClass, getResourceBundle(language));
    }

    private <C, V extends Node> V getViewByController(Class<C> controllerClass, ResourceBundle resourceBundleEN)
    {
        V view = fxWeaver.loadView(controllerClass, resourceBundleEN);
        return Optional.of(view).orElseThrow(() -> new RuntimeException("Unable to load view for controller " + controllerClass));
    }

    public ResourceBundle getResourceBundle(LanguageType language)
    {
        return language == LanguageType.EN ? this.resourceBundleEN : resourceBundleCZ;
    }

    public ResourceBundle getResourceBundle()
    {
        return MainApp.LANGUAGE == LanguageType.EN ? this.resourceBundleEN : resourceBundleCZ;
    }
}
