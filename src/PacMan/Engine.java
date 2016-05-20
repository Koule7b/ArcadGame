package PacMan;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Smery;
import PacMan.sluzby.Pohybovac;
import PacMan.sluzby.VystavenyLevelu;
import PacMan.urovne.Uroven;

import java.util.ArrayList;

/**
 * Engine je třída, která se stará o všechnu interakci ve hře co se týče načítání úrovní, předávání score z úrovně 1. do úrovně 2.
 *Určuje také konec hry, konec úrovně, dokonce i kdo vyhrál, jestli "potvůrky", nebo "hráč".
 */
public class Engine {

    //počet životů, která má hráč.
    private int zivoty = 3;
    private int scoreHrace = 0;
    private int scorePotvurek = 0;
    //aktuální úroveň
    private Uroven aktualni;
    private Pohybovac pohybovac;
    //velikost panelu (šířka)
    private int velikostSirka;
    //velikost panelu (výška)
    private int velikostVyska;
    //proměná, jestli je konec hry
    private boolean konecHry = false;

    private VystavenyLevelu tvorbaUrovne = new VystavenyLevelu();
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
     * Pokavaď ovšem další úroveň lze načíst, tak vytvoří novou instanci třídy Pohybovac, s parametrama aktualnima.
     * (scoreHrace, scorePotvurek, zivoty, aktualni) všechno to jsou údaje, které se mohou v průběhu hry změnit a nejspíš se i změní.
     * Dále se předává pohybovac i velikost okna, která se sice nemění, ale movinator tyto údaje potřebuje, aby mu postavičky neutíkaly
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
            pohybovac = new Pohybovac(velikostSirka, velikostVyska, aktualni, zivoty, scorePotvurek, scoreHrace);
            uroven++;
            return true;
        }
    }

    /**
     * vrací score hráče.
     * @return
     */
    public int getScoreHrace() {
        return pohybovac.getScoreHrace();
    }

    /**
     * vrací score "potvůrek".
     * @return
     */
    public int getScorePotvurek() {
        return pohybovac.getScorePotvurek();
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
    /**
     * vrací ArrayList "superJidla" je to stejné, jako "sváča", jen je větší, jinak barevné a za víc bodů.
     * @return
     */
    public ArrayList<SuperJidlo> getSuperJidlo(){return aktualni.getSuperJidlo();}
    /**
     * vrací proměnou typu Hrac -> vrací hráče.
     * @return
     */
    public Hrac getHrac() {
        return aktualni.getHrac();
    }

    /**
     * vrací ArrayList "překážek".
     * @return
     */
    public ArrayList<Prekazka> getPrekazky() {
        return aktualni.getPrekazky();
    }
    /**
     * vrací životy hráče.
     * @return
     */
    public int getZivotyHrace() {
        return pohybovac.getZivoty();
    }
    /**
     * vrací boolean jestli může načíst další úroveň (jestli další úroveň existuje, jestli je co načíst).
     * @return
     */
    public boolean nactiDalsiUroven(){
        return nactiUroven(uroven);
    }

    /**
     * vrací boolean, jestli je konec hry.
     * @return
     */
    public boolean KonecHry() {
    return konecHry;
    }
    /**
     * vrací boolean, jeslti vyhrál "hráč", nebo "potvůrky".
     * @return
     */
    public boolean HracVyhral(){return getScoreHrace() > getScorePotvurek();}

    /**
     * vrací ArrayList "míst změn směru".
     * @return
     */
    public ArrayList<MistaZmenySmeru> getMistaZmenySmeru() {
        return aktualni.getMistaZmenySmeru();
    }

    /**
     * nastavuje score hráče pomocí getteru z movinatoru3000.
     */
    private void setScoreHrace() {
        scoreHrace = pohybovac.getScoreHrace();
    }

    /**
     * nastavuje score potvůrek pomocí getteru z movinatoru3000.
     */
    private void setScorePotvurek() {
        scorePotvurek = pohybovac.getScorePotvurek();
    }

    /**
     * nastavuje životy hráče pomocí getteru z movinatoru3000.
     */
    private int setZivotyHrace(){return this.zivoty = pohybovac.getZivoty();}

    /**
     * nastavuje pomocí parametru nový směr hráče.
     * @param smer
     */
    public void zmenSmer(Smery smer) {
        aktualni.getHrac().setSmer(smer);
    }

    /**
     * metoda, která volá metodu ze třídy "Pohybovac" "pohniVsim()" a přenastaví proměné score hráče, score potvůrek, životy hráče voláním příslušcých metod.
     */
    public void skok() {
        pohybovac.pohniVsim();
        setZivotyHrace();
        setScorePotvurek();
        setScoreHrace();
    }
}

