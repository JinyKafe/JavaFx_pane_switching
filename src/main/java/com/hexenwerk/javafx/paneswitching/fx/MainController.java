package com.hexenwerk.javafx.paneswitching.fx;

import com.hexenwerk.javafx.paneswitching.StageBuilder;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    @FXML
    public Label headerLabel;

    @FXML
    private StackPane vistaHolder;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        attachVistaPane(stageBuilder.getViewByController(Vista1Controller.class));
    }

    public void attachVistaPane(StackPane stackPane)
    {
        vistaHolder.getChildren().setAll(stackPane);
    }
}