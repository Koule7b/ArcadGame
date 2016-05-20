package PacMan.objekty.jidlo;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Vytvořeno Štěpánem Mudrou 20.5.2016.
 */
public class SvacaTest {
    @Test
    public void getOkraje() throws Exception {
        Svaca s = new Svaca(10, 15);
        assertEquals(new Rectangle(10, 15, 5, 5), s.getOkraje());
    }

}