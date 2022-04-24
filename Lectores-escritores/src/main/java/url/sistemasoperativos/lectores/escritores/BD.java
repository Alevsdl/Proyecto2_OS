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
    }

    public synchronized void closeL(int id, JLabel jLabel1, DefaultListModel modelo, JLabel jLabel3) {

        //lector termina
    }

    public synchronized void openE(int id, JLabel jLabel2, JLabel jLabel4) throws InterruptedException {
        //escritor empieza
    }

    public synchronized void closeE(int id, JLabel jLabel2, JLabel jLabel4) {
        //escritor termina
        
    }
}
