package org.daytoday.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Splash implements Initializable{

    @FXML
    protected ProgressBar loader;

    @FXML
    protected VBox main;

    @FXML
    protected Label loader_status;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        App.drag(main);
        loader.setProgress(0.0);
        start();
    }

    private void start(){

        Loader splash_loading = new Loader() {
            @Override
            protected void loadTasks() {
                System.out.println("Working");
            }
        };

        loader.progressProperty().bind(splash_loading.progressProperty());
        loader_status.textProperty().bind(splash_loading.messageProperty());

        splash_loading.setOnSucceeded(event -> {

            try {
                App.setRoot("Homepage");
            } catch (IOException e) {
                System.out.println(e);
            }

        });

        new Thread(splash_loading).start();

    }

}