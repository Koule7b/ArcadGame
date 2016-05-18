package PacMan.objekty.jidlo;

import PacMan.okna.Hra;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Admin on 24.3.2016.
 */
public class SuperJidlo implements Serializable{
    private int souradniceX, souradniceY, cislo;
    private final int velikost = 10;
    private boolean viditelny = true;
    public SuperJidlo(int x, int y){
        this.souradniceX = x;
        this.souradniceY = y;
    }
    public void vykresleniSuperJidla(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(souradniceX, souradniceY, velikost, velikost);
    }
    public boolean isViditelny(){
        return viditelny;
    }
    public void skryt(){
        viditelny = false;
    }
    public Rectangle getOkraje(){return new Rectangle(souradniceX, souradniceY, velikost, velikost);}
}
