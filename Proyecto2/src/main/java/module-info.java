module com.mycompany.pruebafilechooser {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pruebafilechooser to javafx.fxml;
    exports com.mycompany.pruebafilechooser;
}
