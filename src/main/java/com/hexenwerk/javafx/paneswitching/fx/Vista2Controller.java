package com.hexenwerk.javafx.paneswitching.fx;

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
 * Controller class for the second vista.
 */
@Component
@FxmlView("vista2.fxml")
public class Vista2Controller implements Initializable
{

    @Autowired
    MainController mainController;

    @Autowired
    private FxControllerAndView<Vista1Controller, StackPane> vista1_FX;

    public Button previousButton;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        previousButton.setOnAction(event -> mainController.setVista(vista1_FX.getView().orElseThrow()));
    }
}