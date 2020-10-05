module org.daytoday.app {
    requires javafx.controls;
    requires javafx.fxml;
    requires jfoenix;

    opens org.daytoday.app to javafx.fxml;
    exports org.daytoday.app;
}