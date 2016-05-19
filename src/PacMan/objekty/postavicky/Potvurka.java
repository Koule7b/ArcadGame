package PacMan.objekty.postavicky;

import java.awt.*;

import PacMan.okna.Hra;
/**
 * Created by Admin on 4.4.2016.
 */
import java.util.Random;

public class Potvurka extends Postavicka{

    Color barva = Color.ORANGE;



    public Potvurka(int x, int y, Smery smer) {
        super(x, y, smer);
    }

    public void vykresliSe(Graphics g){
        g.setColor(barva);
        g.fillOval(x, y, velikost, velikost);
    }

    public Rectangle getOkraje(){return new Rectangle(x, y, velikost, velikost);}

}
