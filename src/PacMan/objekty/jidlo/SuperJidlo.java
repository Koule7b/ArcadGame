package PacMan.objekty.jidlo;


import java.awt.*;
import java.io.Serializable;

/**
 * Třída implementující serializable pro serializování.
 */
public class SuperJidlo implements Serializable{

    //souřadnice na osách
    private int souradniceX, souradniceY;

    //velikost
    private final int velikost = 10;

    /**
     * Přiřadí proměným souradniceX a souradniceY hodnoty dle parametrů.
     * @param x
     * @param y
     */
    public SuperJidlo(int x, int y){
        this.souradniceX = x;
        this.souradniceY = y;
    }

    /**
     * vykreslí dané "superJidlo"
     * @param g
     */
    public void vykresleniSuperJidla(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(souradniceX, souradniceY, velikost, velikost);
    }

    /**
     * vrací rovnoběžník okolo daného "superJidla".
     * @return
     */
    public Rectangle getOkraje(){return new Rectangle(souradniceX, souradniceY, velikost, velikost);}
}
