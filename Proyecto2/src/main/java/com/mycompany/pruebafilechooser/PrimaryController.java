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
        long tamanio=recorrerDirectorio(archivo);
        System.out.println("FINALMENTE");
        System.out.println(tamanio);
        }
        
    
    public long recorrerDirectorio(File f){
        //System.out.println(f.getName());    
    long tamanio=0;
    if(f.isFile()){
    tamanio+=f.length();
    System.out.println(f.getName());
    System.out.println(f.length());
    }else{
    if(f.listFiles()==null){
    //tamanio+=f.length();
    }else{        
    for (File x : f.listFiles()) {
    tamanio+=recorrerDirectorio(x);        
    }
    }
    }
 
    return tamanio;
    }
}
