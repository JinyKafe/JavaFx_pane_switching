package com.hexenwerk.javafx.paneswitching.fx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("main.fxml")
public class MainController implements Initializable
{
    @Value("${spring.application.demo.greeting}")
    private String greeting;

    @Autowired
    private FxControllerAndView<Vista1Controller, StackPane> vista1_FX;

    @FXML
    public Label headerLabel;

    @FXML
    private StackPane vistaHolder;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        headerLabel.setText(greeting);
        setVista(vista1_FX.getView().orElseThrow());
    }

    public void setVista(Node node)
    {
        vistaHolder.getChildren().setAll(node);
    }
}