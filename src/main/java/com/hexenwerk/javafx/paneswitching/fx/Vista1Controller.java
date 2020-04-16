package com.hexenwerk.javafx.paneswitching.fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the first vista.
 */
@Component
@FxmlView("vista1.fxml")
public class Vista1Controller implements Initializable
{
    @Autowired
    MainController mainController;

    @Autowired
    private FxControllerAndView<Vista2Controller, StackPane> vista2_FX;

    @FXML
    public Button nextButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nextButton.setOnAction(event -> mainController.setVista(vista2_FX.getView().orElseThrow()));
    }
}