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

    public Hrac() {
        super(125, 230, Smery.stop);
    }

    public void vykresliSe(Graphics g) {
        g.fillRect(x, y, velikost, velikost);
    }
}
