/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package url.sistemasoperativos.lectores.escritores;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author aleja
 */
public class BD {

    private int NLectores = 0;
    private boolean HayEscritor = false;
    private int NEscritor = 0;

    public synchronized void openL(int id, JLabel jLabel1, DefaultListModel modelo, JLabel jLabel3) throws InterruptedException {
        //lector lee
        while (HayEscritor || NEscritor > 0) {
            wait();
        }
        NLectores++;
        jLabel3.setBackground(Color.green);
        jLabel1.setIcon(new javax.swing.ImageIcon("src/main/java/url/sistemasoperativos/lectores/escritores/imagenes/leer.gif"));
        modelo.addElement("Lector " + (id + 1) + " esta leyendo");
        System.out.println("Lector " + (id + 1) + " esta leyendo");
    }

    public synchronized void closeL(int id, JLabel jLabel1, DefaultListModel modelo, JLabel jLabel3) {

        //lector termina
        //jLabel1.setBackground(Color.red);
        modelo.removeElement("Lector " + (id + 1) + " esta leyendo");
        NLectores--;
        if (NLectores == 0) {
            System.out.println("Lector " + (id + 1) + " termino de leer");
            jLabel1.setIcon(new javax.swing.ImageIcon("src/main/java/url/sistemasoperativos/lectores/escritores/imagenes/leer-0000.jpg"));
            jLabel3.setBackground(Color.red);
            notifyAll(); //despertar un al escritor q esta esperando
        }
    }

    public synchronized void openE(int id, JLabel jLabel2, JLabel jLabel4) throws InterruptedException {
        //escritor empieza
    }

    public synchronized void closeE(int id, JLabel jLabel2, JLabel jLabel4) {
        //escritor termina

    }
}
