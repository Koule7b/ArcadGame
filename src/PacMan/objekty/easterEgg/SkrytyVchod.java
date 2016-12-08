package PacMan.objekty.easterEgg;

import java.awt.*;
import java.io.Serializable;

/**
 * Created by Admin on 9.6.2016.
 */
public class SkrytyVchod implements Serializable{
    private int x;
    private int y;
    private int velikost;
    public SkrytyVchod(int x, int y, int velikost){
        this.x = x;
        this.y = y;
        this.velikost = velikost;
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, velikost, velikost);
    }
}
