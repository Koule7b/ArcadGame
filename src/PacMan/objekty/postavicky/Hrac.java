/**
 * Autor: Štěpán Mudra
 */
package PacMan.objekty.postavicky;

import java.awt.*;

/**
 * POdtřída třídy "Postavicka", má na starosti hráče.
 */
public class Hrac extends Postavicka {

    private Color barva;

    /**
     * Konstruktor vytvoří pomocí Konstruktoru v Třídě "Postavicka" hráče na uvedené pozici a s směrem.
     */
    public Hrac() {
        super(125, 230, Smery.stop);
    }

    /**
     * Vykreslení hráče .
     * @param g
     */
    public void vykresliSe(Graphics g) {
        g.setColor(barva);
        g.fillRect(x, y, velikost, velikost);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRect(x, y, velikost, velikost);
    }


    public Color Prebarveni(Color barva){return this.barva = barva;}
}
