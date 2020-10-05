package org.daytoday.app;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Homepage implements Initializable {

    @FXML
    protected VBox content;

    @FXML
    protected ImageView dashboard, tasks, timesheet, projects, settings, exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        App.drag(content);
        setView("Tasks");

        dashboard.setOnMouseClicked(mouseEvent -> {
            setView("Dashboard");
        });

        tasks.setOnMouseClicked(mouseEvent -> {
            setView("Tasks");
        });


        timesheet.setOnMouseClicked(mouseEvent -> {
            try {
                App.openPopup("CreateTask");
            } catch (IOException e) {
                System.out.println("error opening Create Task");
            }
        });

        projects.setOnMouseClicked(mouseEvent -> {
            setView("Tasks");
        });

        settings.setOnMouseClicked(mouseEvent -> {
            setView("Settings");
        });

        exit.setOnMouseClicked(mouseEvent -> {
            System.exit(0);

        });

    }

    private void setView(String view){
        try {
            content.getChildren().clear();
            App.addPane(content, view);

        } catch (Exception e) {
            System.out.println(e);
        }
    }




}