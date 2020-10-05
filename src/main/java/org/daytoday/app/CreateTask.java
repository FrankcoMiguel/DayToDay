package org.daytoday.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.daytoday.data.Task;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateTask implements Initializable {

    @FXML
    protected VBox main;

    @FXML
    protected TextField name;

    @FXML
    protected TextArea description;

    @FXML
    protected DatePicker deadline;

    @FXML
    protected ComboBox<String> tasklist, taglist;

    @FXML
    protected Text errMsg;

    @FXML
    protected Button create, cancel;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        errMsg.setVisible(false);
        seedLists();

        App.drag(main);

        cancel.setOnMouseClicked(mouseEvent -> {
            App.closePopup();
        });

        create.setOnMouseClicked(mouseEvent -> {
            createTask();
        });

    }

    private void createTask(){

        if (!name.getText().isEmpty() && !description.getText().isEmpty() && !deadline.getValue().toString().isEmpty()
                && !tasklist.getValue().isEmpty() && !taglist.getValue().isEmpty()) {

            Task task = new Task(name.getText(), description.getText(), false,
                    deadline.getValue(), tasklist.getValue(), taglist.getValue());

            App.closePopup();

        } else {
            errMsg.setVisible(true);
        }

    }

    private void seedLists(){
        tasklist.getItems().add("Side Projects");
        tasklist.getItems().add("neXus Projects");
        tasklist.setValue(tasklist.getItems().get(0));

        taglist.getItems().add("Important");
        taglist.getItems().add("Less important");
        taglist.setValue(taglist.getItems().get(0));

    }

    @FXML
    protected void hideErrMsg(){

        if (errMsg.isVisible()){
            errMsg.setVisible(false);
        }

    }

}
