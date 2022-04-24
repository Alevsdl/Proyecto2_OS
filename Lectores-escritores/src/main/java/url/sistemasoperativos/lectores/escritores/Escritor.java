package url.sistemasoperativos.lectores.escritores;

import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author diego
 */
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class Escritor extends Thread {

    //generaron de tiempos random
    private static Random r = new Random();
    // instancia del recurso compartido
    private BD base_de_datos;
    //ID del escritor
    private int id; 
    // Etiquetas
    private JLabel jLabel2;
    private JLabel jLabel4;
    DefaultListModel modelo = new DefaultListModel();
    
   //constructor con datos iniciales
    public Escritor(BD bd, int id, JLabel jLabel2, JLabel jLabel4) {
        this.base_de_datos = bd;
        this.id = id;
        this.jLabel2 = jLabel2;
        this.jLabel4 = jLabel4;
    }

    public void run() {
        while (true) {
            try {
                // entra a la base de datos
                base_de_datos.openE(id, jLabel2, jLabel4);
                //escribir en BD
                Thread.sleep(r.nextInt(6000)); //simulacion de escritura
                base_de_datos.closeE(id, jLabel2, jLabel4);
                Thread.sleep(r.nextInt(100));//simulacion de salida
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }
}

