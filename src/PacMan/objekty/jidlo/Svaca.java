/**
 * Autor: Štěpán Mudra
 */
package SemestralniProjektPacMan.objekty.jidlo;

import java.awt.*;
import java.io.Serializable;

/**
 * Třída Svaca implementuje serializable pro serializaci.
 */
public class Svaca implements Serializable{

    //velikost
    private final int DELKASTRANY = 5;

    //souřadnice na osách x a y
    private int x, y;

    /**
     * konstruktor přiřadí x a y hodnotu dle parametrů.
     * @param x
     * @param y
     */
    public Svaca(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * vykreslí danou "sváču".
     * @param g
     */
    public void vykresliSe(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, DELKASTRANY, DELKASTRANY);

    }

    /**
     * vrátí rovnoběžník, kolem dané "sváči".
     * @return
     */
    public Rectangle getOkraje(){
        return new Rectangle(x, y, DELKASTRANY, DELKASTRANY);
    }
}
