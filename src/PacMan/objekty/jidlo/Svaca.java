package PacMan.objekty.jidlo;

import java.awt.*;
import java.io.Serializable;

public class Svaca implements Serializable{
    private final int DELKASTRANY = 5;
    private int x, y;
    private boolean viditelny = true;
    public Svaca(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void vykresliSe(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x, y, DELKASTRANY, DELKASTRANY);

    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, DELKASTRANY, DELKASTRANY);
    }
}
