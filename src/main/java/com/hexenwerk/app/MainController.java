package com.hexenwerk.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * com.hexenwerk.Main controller class for the entire layout.
 */
@Component
@FxmlView("main.fxml")
public class MainController implements Initializable
{
    @Autowired
    private FxControllerAndView<Vista1Controller, StackPane> vista1_FX;

    /**
     * Holder of a switchable vista.
     */
    @FXML
    private StackPane vistaHolder;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        setVista(vista1_FX.getView().get());
    }

    public void setVista(Node node)
    {
        vistaHolder.getChildren().setAll(node);
    }
}