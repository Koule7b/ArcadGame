package PacMan.objekty.jidlo;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Vytvořeno Štěpánem Mudrou 20.5.2016.
 */
public class SuperJidloTest {
    @Test
    public void getOkraje() throws Exception {
        SuperJidlo sj = new SuperJidlo(10, 15);
        assertEquals(new Rectangle(10, 15, 10, 10), sj.getOkraje());
    }

}