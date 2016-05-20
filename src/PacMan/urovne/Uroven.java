package PacMan.urovne;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Smery;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Admin on 19.4.2016.
 */
public class Uroven implements Serializable{
    /**
     * Proměné znázorňují ArrayListy, daného typu.
     */
    private ArrayList<Prekazka> prekazky = new ArrayList<>();
    private ArrayList<Potvurka> potvurky = new ArrayList<>();
    private ArrayList<MistaZmenySmeru> mistaZmenySmeru = new ArrayList<>();
    private ArrayList<SuperJidlo> superJidloo = new ArrayList<>();
    private ArrayList<Svaca> svaca;

    // barvy, které určují okraje a vnitřek.
    private Color barvaVnitrku;
    private Color barvaOkraje;

    //instanční proměná hráč
    private Hrac hrac = new Hrac();

    /**
     * Konstruktor nastaví barvu vnitřku překážek a barvu okrajů překážek dle parametrů.
     * @param barvaVnitrku
     * @param barvaOkraje
     */

    public Uroven(Color barvaVnitrku, Color barvaOkraje){
        this.barvaOkraje = barvaOkraje;
        this.barvaVnitrku = barvaVnitrku;
    }

    /**
     * Metoda přidávající "potvůrku" na pozice dle parametrů a nastaví výchozí směr, dle parametru.
     * @param x
     * @param y
     * @param smer
     */
    public void addPotvurka(int x, int y, Smery smer){
        Potvurka potvurka = new Potvurka(x, y, smer);
        potvurky.add(potvurka);
    }

    /**
     * Metada přidávající překažku na pozice a o velikostech dle parametrů.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     */
    public void addPrekazka(int x, int y, int sirka, int vyska){
        Prekazka prekazka = new Prekazka(x, y, sirka, vyska, barvaVnitrku, barvaOkraje);
        prekazky.add(prekazka);
    }

    /**
     * Metodapřidávající "superJidlo" na určené pozice parametry
     * @param x
     * @param y
     */
    public void addSuperJidlo(int x, int y){
        SuperJidlo superJidlo = new SuperJidlo(x, y);
        superJidloo.add(superJidlo);
    }

    /**
     * Metada přidávající překažku na pozice a o velikostech dle parametrů.
     * @param x
     * @param y
     * @param sirka
     * @param vyska
     */
    public void addMistoZnemySmeru(int x, int y, int sirka, int vyska){
        MistaZmenySmeru mistoZmenySmeru = new MistaZmenySmeru(x, y, sirka, vyska);
        mistaZmenySmeru.add(mistoZmenySmeru);
    }

    /**
     * Metoda, která vytváří "jídlo", celá síť by obsahovala 160 "porcí" v daných rozestupech, ale překontoluje kolizi s překážkami.
     * Pokud "jídlo" je za překážkou nelze ho sníst, proto se ani nevystaví.
     * Na mappě lze vidět jen "jídlo", které skutečně může ovlivnit score.
     */
    public void vytvoreniJidla() {
        svaca = new ArrayList<>();
        for (int i = 0; i < 160; i++) {
            int x = 30 * (i % 10) + 15;
            int y = 30 * (i / 10) + 25;
            boolean kolize = false;
            Svaca s = new Svaca(x, y);
            for (int j = 0; j < prekazky.size(); j++) {
                if (s.getOkraje().intersects(prekazky.get(j).getOkraje())) {
                    kolize = true;
                }

            }
            if (kolize == false) {
                svaca.add(s);
            }
        }
    }

    /**
     * vrací Místa, kde "potvůrky" mohou změnit směr
     * @return
     */
    public ArrayList<MistaZmenySmeru> getMistaZmenySmeru(){
        return mistaZmenySmeru;
    }

    /**
     * Vrací překážky.
     * @return
     */
    public ArrayList<Prekazka> getPrekazky() {
        return prekazky;
    }

    /**
     * Vrací potvůrky.
     * @return
     */
    public ArrayList<Potvurka> getPotvurky() {
        return potvurky;
    }

    /**
     * Vrací "jídlo" (potravu).
     * @return
     */
    public ArrayList<Svaca> getSvaca() {
        return svaca;
    }

    /**
     * Vrací "superJidlo" (stejné, jako jídlo, jen jiná velikost barva a bodové hodnocení).
     * @return
     */
    public ArrayList<SuperJidlo> getSuperJidlo(){return superJidloo;}

    /**
     * Vrací hráče.
     * @return
     */
    public Hrac getHrac() {return hrac;}
}
