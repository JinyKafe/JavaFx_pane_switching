package com.hexenwerk.javafx.paneswitching.fx;

import com.hexenwerk.javafx.paneswitching.fx.service.SceneBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("vista1.fxml")
public class Vista1Controller implements Initializable
{
    @Autowired
    SceneBuilder sceneBuilder;

    @Autowired
    MainController mainController;

    @FXML
    public Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nextButton.setOnAction(event -> mainController.attachVistaPane(sceneBuilder.getViewByController(Vista2Controller.class)));
    }
}