package PacMan.objekty.jidlo;

import java.awt.*;

/**
 * Created by Admin on 6.5.2016.
 */
public class SiloKoule {
    int x, y, velikost;
    public SiloKoule(int x, int y, int velikost){
        this.x = x;
        this.y = y;
        this.velikost = velikost;
    }
    public void vykresliSe(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(x, y, velikost, velikost);
    }
    public Rectangle getOkraje(){return new Rectangle(x, y, velikost, velikost);}
}
