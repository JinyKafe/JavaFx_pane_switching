package com.hexenwerk.app;

import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:rene.gielen@gmail.com">Rene Gielen</a>
 */
@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent>
{

    @Autowired
    private FxWeaver fxWeaver;

    @Override
    public void onApplicationEvent(StageReadyEvent event)
    {
        Stage stage = event.stage;
        Scene scene = new Scene(fxWeaver.loadView(MainController.class), 400, 300);
        scene.getStylesheets().setAll(getClass().getResource("vista.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
