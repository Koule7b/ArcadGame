package PacMan;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Smery;
import PacMan.sluzby.Movinator3000;
import PacMan.sluzby.VystavenyLevelu;
import PacMan.urovne.Uroven;

import java.util.ArrayList;

/**
 * Engine je třída, která se stará o všechnu interakci ve hře co se týče načítání úrovní, předávání score z úrovně 1. do úrovně 2.
 *Určuje také konec hry, konec úrovně, dokonce i kdo vyhrál, jestli "potvůrky", nebo "hráč".
 */
public class Engine {
    private int zivoty = 3;
    protected int scoreHrace = 0;
    protected int scorePotvurek = 0;
    protected Uroven aktualni;
    protected Movinator3000 movinator3000;
    private int velikostSirka;
    private int velikostVyska;
    private boolean konecHry = false;

    protected VystavenyLevelu tvorbaUrovne = new VystavenyLevelu();
    private int uroven = 0;

    /**
     *Nastaví šířku a výšku panelu, načte úroveň 0 (indexace úrovní od 0).
     * @param velikostSirka
     * @param velikostVyska
     */
    public Engine(int velikostSirka, int velikostVyska) {
        this.velikostSirka = velikostSirka;
        this.velikostVyska = velikostVyska;
        nactiUroven(uroven);
    }

    /**
     * vrátí, boolean, jestli je konec úrovně (true), nebo ne (false)
     * konce úrovně se zjišťuje pomocí "snědených" bodů "jídla".
     * @return
     */
    public boolean konecLevelu(){
        return getSvaca().size() == 0;
    }

    /**
     * Tato metoda má na starosti přetvoření aktuální úrovně na úroveň, kterou načte pomocí "tvorbaUrovne.nacti(cisloUrovne)".
     * cisloUrovne je parametr, který určuje, jakou úrovneň zrovna načte (indexováno od 0).
     * Dále zkontroluje, jestli další úroveň je null (pokud ano znamená to, že další úroveň není vytvořená a nastaví konec hry na true.
     * Pokavaď ovšem další úroveň lze načíst, tak vytvoří novou instanci třídy Movinator3000, s parametrama aktualnima.
     * (scoreHrace, scorePotvurek, zivoty, aktualni) všechno to jsou údaje, které se mohou v průběhu hry změnit a nejspíš se i změní.
     * Dále se předává movinator3000 i velikost okna, která se sice nemění, ale movinator tyto údaje potřebuje, aby mu postavičky neutíkaly
     * z hrací plochy.
     * Poté "nactiUroven(cisloUrovne) navýší proměnou úroveň o jednu výš, aby nenačítala pořád dokola stejnou úroveň.
     * @param cisloUrovne
     * @return
     */
    public boolean nactiUroven(int cisloUrovne) {

        aktualni = tvorbaUrovne.nacti(cisloUrovne);
        if(aktualni == null){
            konecHry = true;
            return false;
        }else {
            movinator3000 = new Movinator3000(velikostSirka, velikostVyska, aktualni, zivoty, scorePotvurek, scoreHrace);
            uroven++;
            return true;
        }
    }

    /**
     * vrací score hráče.
     * @return
     */
    public int getScoreHrace() {
        return movinator3000.getScoreHrace();
    }

    /**
     * vrací score "potvůrek".
     * @return
     */
    public int getScorePotvurek() {
        return movinator3000.getScorePotvurek();
    }

    /**
     * vrací ArrayList "sváči" bodů, které ještě postavičky "nesnědly".
     * @return
     */
    public ArrayList<Svaca> getSvaca() {
        return aktualni.getSvaca();
    }

    /**
     * vrací ArrayList "potvůrek".
     * @return
     */
    public ArrayList<Potvurka> getPotvurky() {
        return aktualni.getPotvurky();
    }
    public ArrayList<SuperJidlo> getSuperJidlo(){return aktualni.getSuperJidlo();}

    public Hrac getHrac() {
        return aktualni.getHrac();
    }

    public ArrayList<Prekazka> getPrekazky() {
        return aktualni.getPrekazky();
    }

    public int getZivotyHrace() {
        return movinator3000.getZivoty();
    }

    public boolean nactiDalsiUroven(){
        return nactiUroven(uroven);
    }

    public boolean KonecHry() {
    return konecHry;
    }
    public boolean HracVyhral(){return getScoreHrace() > getScorePotvurek();}

    public ArrayList<MistaZmenySmeru> getMistaZmenySmeru() {
        return aktualni.getMistaZmenySmeru();
    }


    private void setScoreHrace() {
        scoreHrace = movinator3000.getScoreHrace();
    }

    private void setScorePotvurek() {
        scorePotvurek = movinator3000.getScorePotvurek();
    }
    private int setZivotyHrace(){return this.zivoty = movinator3000.getZivoty();}

    public void zmenSmer(Smery smer) {
        aktualni.getHrac().setSmer(smer);
    }

    public void skok() {
        movinator3000.pohniVsim();
        setZivotyHrace();
        setScorePotvurek();
        setScoreHrace();
    }
}

