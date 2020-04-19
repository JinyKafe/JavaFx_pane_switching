package com.hexenwerk.javafx.paneswitching.fx;

import com.hexenwerk.javafx.paneswitching.Language;
import com.hexenwerk.javafx.paneswitching.SpringbootJavaFxApplication;
import com.hexenwerk.javafx.paneswitching.StageBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("main.fxml")
public class MainController implements Initializable
{

    @Autowired
    private StageBuilder stageBuilder;

    @Autowired
    private SpringbootJavaFxApplication springbootJavaFxApplication;

    @FXML
    public Button languageButton;

    @FXML
    public Label headerLabel;

    @FXML
    private StackPane vistaHolder;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        languageButton.setText(stageBuilder.getResourceBundle().getString("main.button.language.en"));
        languageButton.setOnAction(event ->
        {
            stageBuilder.toggleLanguage();
            String languageKey = stageBuilder.getLanguage() == Language.EN ? "main.button.language.en" : "main.button.language.cz";
            languageButton.setText(stageBuilder.getResourceBundle().getString(languageKey));

        });
        attachVistaPane(stageBuilder.getViewByController(Vista1Controller.class));
    }

    public void attachVistaPane(StackPane stackPane)
    {
        vistaHolder.getChildren().setAll(stackPane);
    }
}