package PacMan.objekty.postavicky;

import java.io.Serializable;

/**
 * Abstraktní třída implementující serializable z důvodu serializace a zapisování do souboru.
 */
abstract public class Postavicka implements Serializable{
    //suřadnice na osách x, y
    protected int x;
    protected int y;

    //velikost
    protected int velikost = 20;

    // proměná typu Smery, které se přiřadí směr dle nastavení.
    private Smery smer;

    //proměná typu int udávanící počet pixelů za 1 skok (obnovení plochy).
    private int rychlost = 1;

    /**
     * KOnstruktor postavičky nastaví souřadnice a směr dle parametrů.
     * @param x
     * @param y
     * @param smer
     */
    public Postavicka(int x, int y, Smery smer) {
        this.x = x;
        this.y = y;
        this.smer = smer;
    }

    /**
     * Vytvoří lokální proměnou typu int[], zavolá metodu bodouciPozice() a nastaví aktuální souřadnice dle hodnot budouciPozice().
     */
    public void pohyb() {
        int[] pozice = budouciPozice();
        x = pozice[0];
        y = pozice[1];
    }

    /**
     * nastaví x - ovou souřadnici dle parametru.
     * @param x
     * @return
     */
    public int setX(int x){return this.x = x;}

    /**
     * nastaví y - novou souřadnice dle parametru
     * @param y
     * @return
     */
    public int setY(int y){return this.y = y;}

    /**
     * Metoda s návratovým typem int[] porovná směr, ve kterém posíláme postavičku s dostupnýmy směry, až na stop (v něm není žádná interakce).
     * Dle shody směrů přičte/odečte k příslušné pozici rychlost.
     * vrátí pole o dvou prvních pozice[0] x - ová souřadnice pozice[1] y - nová souřadnice.
     * @return
     */
    public int[] budouciPozice() {
        int[] pozice = new int[] {x, y};
        switch (smer) {
            case dolu:
                pozice[1] += rychlost;
                break;
            case nahoru:
                pozice[1] -= rychlost;
                break;
            case levo:
                pozice[0] -= rychlost;
                break;
            case pravo:
                pozice[0] += rychlost;
                break;
        }
        return pozice;
    }

    /**
     * nastaví směr dle parametru
     * @param smer
     */
    public void setSmer(Smery smer){
        this.smer = smer;
    }

    /**
     * vrací velikost postavičky.
     * @return
     */
    public int getVelikost(){
        return velikost;
    }
}

