package PacMan.objekty.postavicky;

import PacMan.objekty.jidlo.Svaca;

import java.awt.*;
public class Potvurka {
    private int pp1, pp2, smerX, smerY, rychlostP1, cislo;
    public Potvurka() {
        Bod1();
    }
    public void Bod1() {
        pp1 = 150;
        pp2 = 346;
        rychlostP1 = 2;
        //polohaPotvurky();
    }
    /**
    public void polohaPotvurky(){
        this.smerr = smerr;
        pp1 += smerX;
        smerX = rychlostP1;
        if(pp1 < 45){
            rychlostP1 = 2;
        }
        if(pp1 > 235){
            rychlostP1 = - 2;
        }
    }
     */
    public void kresleniPotvurky1(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(150, 346, 20, 20);
    }
    public Rectangle getOkrajePP1(){
        return new Rectangle(pp1, pp2, 20, 20);
    }
}
