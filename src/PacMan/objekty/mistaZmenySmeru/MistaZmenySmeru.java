package PacMan.objekty.mistaZmenySmeru;

import java.awt.*;
import java.io.Serializable;

/**
 * Trída MistaZmenySmeru implementuje serializable pro serializaci.
 * Místa slouží pro určení, kde "potvurky" mohou s určitou pravděpodobností změnit směr "náhodně".
 * Dále řešeno v Pohybovac.
 */
public class MistaZmenySmeru implements Serializable {
    //souřadnice na osách
    private int x;
    private int y;

    //velikosti
    private int sirka;
    private int vyska;

    /**
     * Konstruktor přiřadí souřadnicím a velikostem hodnoty.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     */
    public MistaZmenySmeru(int x, int y, int sirka, int vyska){
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }

    /**
     * Vykreslení (finální uživatel je neuvidí, bude metoda zakomentována, ale pro vytváření úrovní přehlednější).
     * @param g
     */
    public void vykresliSe(Graphics g){
        g.setColor(Color.CYAN);
        g.drawRect(x, y, sirka, vyska);
    }

    /**
     * Vrací rovnoběžník Místa změny směru.
     * @return
     */
    public Rectangle getOkraje(){
        return new Rectangle(x, y, sirka, vyska);
    }
}
