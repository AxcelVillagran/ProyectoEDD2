package com.mycompany.pruebafilechooser;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        Stage s = new Stage();
        DirectoryChooser f = new DirectoryChooser();
        File archivo = f.showDialog(s);
        for (File x : archivo.listFiles()) {
            System.out.println(x.getName());
            System.out.println(x.length());
        }
    }
}
