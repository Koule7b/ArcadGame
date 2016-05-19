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
 * This abstract class includes all of thinks witch have all class in share.
 * For example Pac-Man's pills, power pill(if power pill exist), walls, ghosts & player's figure.
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

    public Engine(int velikostSirka, int velikostVyska) {
        //hrac = new Hrac();
        this.velikostSirka = velikostSirka;
        this.velikostVyska = velikostVyska;
        nactiUroven(uroven);
    }
    public boolean konecLevelu(){
        return getSvaca().size() == 0;
    }

    public boolean nactiUroven(int cisloUrovene) {

        aktualni = tvorbaUrovne.nacti(cisloUrovene);
        if(aktualni == null){
            konecHry = true;
            return false;
        }else {
            movinator3000 = new Movinator3000(velikostSirka, velikostVyska, aktualni, zivoty, scorePotvurek, scoreHrace);
            uroven++;
            return true;
        }
    }

    public int getScoreHrace() {
        return movinator3000.getScoreHrace();
    }

    public int getScorePotvurek() {
        return movinator3000.getScorePotvurek();
    }

    public ArrayList<Svaca> getSvaca() {
        return aktualni.getSvaca();
    }

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

