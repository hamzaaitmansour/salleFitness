module com.example.gym {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.gym to javafx.fxml;
    exports com.example.gym;
}