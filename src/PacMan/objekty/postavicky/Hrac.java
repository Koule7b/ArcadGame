package PacMan.objekty.postavicky;

import PacMan.okna.Hra;
import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Hrac extends Postavicka {
    //private Color barva = Color.WHITE;
    //protected Image hrac = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\Hra\\src\\Grafika\\Hrac.PNG").getImage();
    private Hra hra;

    public Hrac() {
        super(125, 230, Smery.stop);
    }

    public void vykresliSe(Graphics g) {
        //g.drawImage(hrac, x, y, velikost, velikost, hra);
        g.fillRect(x, y, velikost, velikost);
    }
}
