/**
 * Autor: Štěpán Mudra
 */
package PacMan.objekty;

import java.awt.*;
import java.io.Serializable;

/**
 * Třída, která implementuje Serializable, kvůli serializaci a ukládání do souboru.
 */
public class Prekazka implements Serializable{
    //souřadnice na osách x a y
    private int x;
    private int y;

    //velikosti
    private  int sirka;
    private int vyska;

    //barvy okrajů a vnitřků
    private Color barvaVnitrku;
    private Color barvaOkraje;

    /**
     * V konstruktoru se nastaví souřadnice překážky, velikost, barva vnitřku a okraje dle parametrů.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     * @param barvaVnitrku
     * @param barvaOkraje
     */
    public Prekazka(int x, int y, int sirka, int vyska, Color barvaVnitrku, Color barvaOkraje) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.barvaVnitrku = barvaVnitrku;
        this.barvaOkraje = barvaOkraje;
    }

    /**
     * Metoda vrací rovnoběžník o souřadnicích a velikostech překážky.
     * @return
     */
    public Rectangle getOkraje() {
        return new Rectangle(x, y, sirka, vyska);
    }

    /**
     * Metoda má na starosti vykreslení překážky.
     * @param g
     */
    public void vykresliSe(Graphics g){
        g.setColor(barvaVnitrku);
        g.fillRect(x, y, sirka, vyska);
        g.setColor(barvaOkraje);
        g.drawRect(x, y, sirka, vyska);
    }
}
