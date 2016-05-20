package PacMan.objekty.postavicky;

import java.awt.*;

/**
 * Podtřída třídy "Postavicka", má na starosti vše okolo "potvůrek".
 */

public class Potvurka extends Postavicka{

    //proměná typu Color se přiřadí oranžová.
    private Color barva = Color.ORANGE;

    /**
     * konstrukor nastaví souřadnice "potvůrek" a výchozí směr, přes Konstruktor "Postavicka" v třídě Postavicka.
     * @param x
     * @param y
     * @param smer
     */
    public Potvurka(int x, int y, Smery smer) {
        super(x, y, smer);
    }

    /**
     * Metoda vykreslující "potvůrku".
     * @param g
     */
    public void vykresliSe(Graphics g){
        g.setColor(barva);
        g.fillOval(x, y, velikost, velikost);
    }

    /**
     * Metoda vracející rovnoběžník "potvůrky".
     * @return
     */
    public Rectangle getOkraje(){return new Rectangle(x, y, velikost, velikost);}

}
