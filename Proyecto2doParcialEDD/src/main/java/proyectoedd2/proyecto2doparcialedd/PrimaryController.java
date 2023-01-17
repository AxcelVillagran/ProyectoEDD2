package proyectoedd2.proyecto2doparcialedd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    VBox vboxMain;
    @FXML
    HBox hboxR;
    @FXML
    Label labelRuta;
    @FXML
    Label labelPeso;
    
    @FXML
    private void switchToSecondary() throws IOException {
        hboxR.getChildren().clear();
        Stage s=new Stage();
        DirectoryChooser f = new DirectoryChooser();
        File archivo = f.showDialog(s);
        ArbolFiles<File> elegido=new ArbolFiles(archivo);
        
        hboxR.getChildren().addAll(recorridoEnAnchura(elegido));
        //System.out.println(elegido.pesoKB);
        // ver si esta bien
        //System.out.println(elegido.hijos[0].pesoKB);
        }
    
    
        public Pane recorridoEnAnchura(ArbolFiles<File> arbol) {
        Random ra = new Random();
        int low = 1;
        int high = 256;
        //int result = r.nextInt(high-low) + low;    
        Pane p=new Pane();
        Queue<ArbolFiles<File>> cola = new ArrayDeque();
        cola.offer(arbol);
        double referenciaX;
        double referenciaY;
        Rectangle referencia;
        Rectangle padre=new Rectangle(1200,600);
        p.getChildren().add(padre);
//        padre.setFocusTraversable(true);
//                    padre.setOnMouseEntered(e->{
//                        padre.setStyle("-fx-fill:blue");
//                    });
//                    padre.setOnMouseExited(e->{
//                        padre.setStyle("-fx-fill:black");
//                    });
        int contador=0;
        int corte=0;
        while (!cola.isEmpty()) {
            referencia=(Rectangle)p.getChildren().get(contador);
            referenciaX=referencia.getX();
            referenciaY=referencia.getY();
            ArbolFiles<File> eliminado = cola.poll();
            //System.out.println(eliminado.root.getName());
            if (eliminado.hijos != null) {
                for (ArbolFiles<File> ar : eliminado.hijos) {
//                PriorityQueue<ArbolFiles<File>>hijos=eliminado.hijos;
//                while(!hijos.isEmpty()){
//                    ArbolFiles<File> ar=hijos.poll();
                    cola.offer(ar);
                    Rectangle r;
                    if(corte%2==0){
                        r=new Rectangle(referencia.getWidth(),referencia.getHeight()*ar.pesoMB/eliminado.pesoMB);
                        r.setX(referenciaX);
                        r.setY(referenciaY);
                        referenciaY+=r.getHeight();
                    }else{
                        r=new Rectangle(referencia.getWidth()*ar.pesoMB/eliminado.pesoMB,referencia.getHeight());
                        r.setX(referenciaX);
                        r.setY(referenciaY);
                        referenciaX+=r.getWidth();
                    }
                    p.getChildren().add(r);
                    int a=ra.nextInt(high-low) + low;
                    int b=ra.nextInt(high-low) + low;
                    int c=ra.nextInt(high-low) + low;
                    r.setFill(Color.rgb(a,b,c));
                    r.setFocusTraversable(true);
                    r.setOnMouseEntered(e->{
                        labelRuta.setText(ar.root.getAbsolutePath());
                        labelPeso.setText(String.valueOf(ar.pesoMB)+" MB ("+ar.pesoMB*1024.0*1024.0+" bytes)");
                    });
                    r.setOnMouseExited(e->{
                        labelRuta.setText("");
                        labelPeso.setText("");
                    });
                }
                corte+=1;
            }
            contador+=1;
        }
        return p;
    }
    
   
}