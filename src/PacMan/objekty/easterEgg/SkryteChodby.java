package SemestralniProjektPacMan.objekty.easterEgg;

import java.awt.*;
import java.io.Serializable;

/**
 * Vytvořeno Štěpánem Mudrou on 25.5.2016.
 */

public class SkryteChodby implements Serializable {

    private int x, y, sirka, vyska;

    public SkryteChodby(int x, int y, int sirka, int vyska){
        this.x = x;
        this.y = y;
        this.sirka = sirka;
        this.vyska = vyska;
    }

    public void vykresliSe(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, sirka, vyska);
    }
    public Rectangle getOkraje(){
        return new Rectangle(x, y, sirka, vyska);
    }
}