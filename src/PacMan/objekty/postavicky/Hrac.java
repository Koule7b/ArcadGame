package PacMan.objekty.postavicky;

import java.awt.*;

/**
 * POdtřída třídy "Postavicka", má na starosti hráče.
 */
public class Hrac extends Postavicka {

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
        g.fillRect(x, y, velikost, velikost);
    }
}
