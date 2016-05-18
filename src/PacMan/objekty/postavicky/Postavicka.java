package PacMan.objekty.postavicky;

import PacMan.Engine;
import PacMan.Grafika;
import PacMan.Spusteni;
import PacMan.okna.Hra;
import PacMan.sluzby.Movinator3000;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Admin on 7.4.2016.
 */
abstract public class Postavicka implements Serializable{
    protected int x;
    protected int y;
    protected int velikost = 20;

    protected Smery smer;
    protected int rychlost = 1;

    public Postavicka(int x, int y, Smery smer) {
        this.x = x;
        this.y = y;
        this.smer = smer;
    }

    public void pohyb() {
        int[] pozice = budouciPozice();
        x = pozice[0];
        y = pozice[1];
    }
    public int setX(int x){return this.x = x;}
    public int setY(int y){return this.y = y;}

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
    public void setSmer(Smery smer){
        this.smer = smer;
    }
    public int getVelikost(){
        return velikost;
    }
}

