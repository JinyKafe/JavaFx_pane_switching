package com.hexenwerk.javafx.paneswitching;

import javafx.scene.Node;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.spring.InjectionPointLazyFxControllerAndViewResolver;
import net.rgielen.fxweaver.spring.SpringFxWeaver;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class AppConfig
{
    @Bean
    public FxWeaver fxWeaver(ConfigurableApplicationContext applicationContext)
    {
        return new SpringFxWeaver(applicationContext);
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public <C, V extends Node> FxControllerAndView<C, V> controllerAndView(FxWeaver fxWeaver, InjectionPoint injectionPoint)
    {
        return new InjectionPointLazyFxControllerAndViewResolver(fxWeaver).resolve(injectionPoint);
    }

    @Bean("resourceBundleEN")
    @Primary
    public ResourceBundle resourceBundle_en()
    {
        Locale locale = new Locale("en");
        return ResourceBundle.getBundle("Bundle", locale);
    }

    @Bean("resourceBundleCZ")
    public ResourceBundle resourceBundle_cz()
    {
        Locale locale = new Locale("cs");
        return ResourceBundle.getBundle("Bundle", locale);
    }
}