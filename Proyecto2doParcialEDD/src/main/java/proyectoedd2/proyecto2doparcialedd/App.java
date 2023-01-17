package proyectoedd2.proyecto2doparcialedd;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.stage.DirectoryChooser;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
         scene = new Scene(loadFXML("primary"), 1280, 720);
        stage.setScene(scene);
        stage.show();
        
    }

    
    
    public static double contarPeso(File f){
        //System.out.println(f.getName());    
    double tamanio=0.0;
    if(f.isFile()){
//        System.out.println(f.length());
//        System.out.println(f.length()/1024.0);
    tamanio+=(f.length()/1024.0/1024.0);
        //System.out.println(tamanio);
//    System.out.println(f.getName());
//    System.out.println(f.length());
    }else{
    if(f.listFiles()==null){
    //tamanio+=f.length();
    }else{        
    for (File x : f.listFiles()) {
    tamanio+=contarPeso(x);        
    }
    }
    }
        //System.out.println(tamanio);
    tamanio=Math.round(tamanio*100.0)/100.0;
    return tamanio;
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}