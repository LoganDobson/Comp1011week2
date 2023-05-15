module com.example.comp1011week2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp1011week2 to javafx.fxml;
    exports com.example.comp1011week2;
}