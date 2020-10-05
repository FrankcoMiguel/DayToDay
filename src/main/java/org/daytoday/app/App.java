package org.daytoday.app;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX org.daytoday.controller.App
 */
public class App extends Application {

    private static Scene scene;
    private static double x, y;
    private static Stage popupStage;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Homepage"));
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void addPane(Pane main, String fxml) throws Exception {
        main.getChildren().add(loadFXML(fxml));
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void openPopup(String fxml) throws IOException {
        popupStage = new Stage();
         Scene popupScene = new Scene(loadFXML(fxml));
         popupStage.setScene(popupScene);
         popupStage.initStyle(StageStyle.UNDECORATED);
        scene.getWindow().setOpacity(0.0);
        scene.getRoot().setDisable(true);
        popupStage.show();

    }

    static void closePopup(){
        scene.getWindow().setOpacity(1.0);
        scene.getRoot().setDisable(false);
        popupStage.close();
    }





    static void drag(Pane pane){

        pane.setOnMousePressed(event -> {
            pane.setCursor(Cursor.OPEN_HAND);
            x = event.getSceneX();
            y = event.getSceneY();
        });

        pane.setOnMouseDragged(event -> {
            pane.setCursor(Cursor.CLOSED_HAND);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        pane.setOnMouseReleased(event -> pane.setCursor(Cursor.DEFAULT));

    }





    public static void main(String[] args) {
        launch();
    }

}