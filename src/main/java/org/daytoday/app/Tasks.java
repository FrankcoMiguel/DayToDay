package org.daytoday.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.daytoday.data.Task;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Tasks implements Initializable {

    @FXML
    protected VBox taskList;
    List<Task> dataTaskList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Task task1 = new Task("Day to Day push to Github","Bla bla",false,LocalDate.of(2020,10,12),"XD","Xd");
        Task task2 = new Task("neXus meeting","Bla bla",true,LocalDate.of(2020,10,12),"XD","XD");
        Task task3 = new Task("Resolve PacFIN Issues","Bla blo blue",false,LocalDate.of(2020,10,12),"XD","XD");
        Task task4 = new Task("Day to Day push to Github","Bla bla",false,LocalDate.of(2020,10,12),"XD","Xd");
        Task task5 = new Task("neXus meeting","Bla bla",true,LocalDate.of(2020,10,12),"XD","XD");
        Task task6 = new Task("Resolve PacFIN Issues","Bla blo blue",false,LocalDate.of(2020,10,12),"XD","XD");
        Task task7 = new Task("Day to Day push to Github","Bla bla",false,LocalDate.of(2020,10,12),"XD","Xd");
        Task task8 = new Task("neXus meeting","Bla bla",true,LocalDate.of(2020,10,12),"XD","XD");
        Task task9 = new Task("Resolve PacFIN Issues","Bla blo blue",false,LocalDate.of(2020,10,12),"XD","XD");



        dataTaskList = new ArrayList<>();
        dataTaskList.add(task1);
        dataTaskList.add(task2);
        dataTaskList.add(task3);
        dataTaskList.add(task4);
        dataTaskList.add(task5);
        dataTaskList.add(task6);
        dataTaskList.add(task7);
        dataTaskList.add(task8);
        dataTaskList.add(task9);
        dataTaskList.size();

        for (Task task: dataTaskList){

            try {
                generateTask(task);
            } catch (Exception e) {
                System.out.println(e +"\n here");
            }

        }
    }


    private void generateTask(Task task){

        //Container
        HBox hBox = new HBox(20.0);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.prefHeight(74.0);
        hBox.prefWidth(600.0);
        hBox.setPadding(new Insets(30.0));
        hBox.setStyle("-fx-background-color: #355C7D");
        //CheckBox and if it is complete
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(task.isDone());
        //The task name
        Label label = new Label(task.getName());
        label.setFont(new Font("Arial Bold",17.0));
        //And finally put all together
        hBox.getChildren().addAll(checkBox,label);
        taskList.getChildren().add(hBox);
    }


}
