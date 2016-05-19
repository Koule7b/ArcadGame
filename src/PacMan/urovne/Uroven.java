package PacMan.urovne;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SiloKoule;
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
    protected ArrayList<Prekazka> prekazky = new ArrayList<>();
    protected ArrayList<Potvurka> potvurky = new ArrayList<>();
    protected ArrayList<MistaZmenySmeru> mistaZmenySmeru = new ArrayList<>();
    protected ArrayList<SuperJidlo> superJidloo = new ArrayList<>();
    protected ArrayList<Svaca> svaca;
    protected ArrayList<SiloKoule> silokoule = new ArrayList<>();


    protected Color barvaVnitrku;
    protected Color barvaOkraje;

    protected Hrac hrac = new Hrac();

    public Uroven(Color barvaVnitrku){
        this.barvaOkraje = barvaVnitrku;
        this.barvaVnitrku = barvaVnitrku;
    }

    public Uroven(Color barvaVnitrku, Color barvaOkraje){
        this.barvaOkraje = barvaOkraje;
        this.barvaVnitrku = barvaVnitrku;
    }

    public void addPotvurka(int x, int y, Smery smer){
        Potvurka potvurka = new Potvurka(x, y, smer);
        potvurky.add(potvurka);
    }

    public void addPrekazka(int x, int y, int sirka, int vyska){
        Prekazka prekazka = new Prekazka(x, y, sirka, vyska, barvaVnitrku, barvaOkraje);
        prekazky.add(prekazka);
    }
    public void addSuperJidlo(int x, int y){
        SuperJidlo superJidlo = new SuperJidlo(x, y);
        superJidloo.add(superJidlo);
    }
    public void addMistoZnemySmeru(int x, int y, int sirka, int vyska){
        MistaZmenySmeru mistoZmenySmeru = new MistaZmenySmeru(x, y, sirka, vyska);
        mistaZmenySmeru.add(mistoZmenySmeru);
    }
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
    public ArrayList<MistaZmenySmeru> getMistaZmenySmeru(){
        return mistaZmenySmeru;
    }

    public ArrayList<Prekazka> getPrekazky() {
        return prekazky;
    }

    public ArrayList<Potvurka> getPotvurky() {
        return potvurky;
    }

    public ArrayList<Svaca> getSvaca() {
        return svaca;
    }
    public ArrayList<SuperJidlo> getSuperJidlo(){return superJidloo;}
    public ArrayList<SiloKoule> getSilokoule(){return silokoule;}

    public Hrac getHrac() {return hrac;}
}
