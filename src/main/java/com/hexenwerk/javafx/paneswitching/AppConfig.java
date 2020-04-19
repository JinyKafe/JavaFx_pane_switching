package com.hexenwerk.javafx.paneswitching;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Locale;
import java.util.ResourceBundle;

@Configuration
public class AppConfig
{
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
