package PacMan.objekty;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Admin on 20.5.2016.
 */
public class PrekazkaTest {
    @Test
    public void getOkraje() throws Exception {
        Prekazka p = new Prekazka(10, 15, 15, 10, Color.YELLOW, Color.CYAN);
        assertEquals(new Rectangle(10, 15, 15, 10), p.getOkraje());
    }

}