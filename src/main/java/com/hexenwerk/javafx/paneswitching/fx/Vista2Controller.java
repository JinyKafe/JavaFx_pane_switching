package com.hexenwerk.javafx.paneswitching.fx;

import com.hexenwerk.javafx.paneswitching.Language;
import com.hexenwerk.javafx.paneswitching.StageBuilder;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("vista2.fxml")
public class Vista2Controller implements Initializable
{
    @Autowired
    private StageBuilder stageBuilder;

    @Autowired
    MainController mainController;

    public Button previousButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        previousButton.setOnAction(event -> mainController.attachVistaPane(stageBuilder.getViewByController(Vista1Controller.class, Language.CZ)));
    }
}