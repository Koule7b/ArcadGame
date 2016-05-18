package PacMan.objekty;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Admin on 19.4.2016.
 */
public class Prekazka implements Serializable{
    private int x;
    private int y;
    private  int sirka;
    private int vyska;
    private Color barvaVnitrku;
    private Color barvaOkraje;
    public Prekazka(int x, int y, int sirka, int vyska, Color barvaVnitrku, Color barvaOkraje) {
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
        this.barvaVnitrku = barvaVnitrku;
        this.barvaOkraje = barvaOkraje;
    }
    public Rectangle getOkraje() {
        return new Rectangle(x, y, sirka, vyska);
    }

    public void vykresliSe(Graphics g){
        g.setColor(barvaVnitrku);
        g.fillRect(x, y, sirka, vyska);
        g.setColor(barvaOkraje);
        g.drawRect(x, y, sirka, vyska);
    }
}
