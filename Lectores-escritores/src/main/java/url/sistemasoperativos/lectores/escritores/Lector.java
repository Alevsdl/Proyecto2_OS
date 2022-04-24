package url.sistemasoperativos.lectores.escritores;

/*
 * @author User
 */
import java.util.*;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class Lector extends Thread {

    private static Random r = new Random();
    private BD base_de_datos;
    private int id;//el id del lector
    private JLabel jLabel1;
    private JLabel jLabel3;
    DefaultListModel modelo = new DefaultListModel();

    public Lector(BD gestor, int id,JLabel jLabel1,DefaultListModel modelo, JLabel jLabel3) {
        this.base_de_datos = gestor;
        this.id = id;
        this.jLabel1=jLabel1;
        this.jLabel3=jLabel3;
        this.modelo=modelo;
    }

    public void run() {
        while (true) {
            try {
                base_de_datos.openL(id, jLabel1,modelo,jLabel3);
                //leyendo BD
                Thread.sleep(r.nextInt(6000));
                base_de_datos.closeL(id,jLabel1,modelo,jLabel3);
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }


}