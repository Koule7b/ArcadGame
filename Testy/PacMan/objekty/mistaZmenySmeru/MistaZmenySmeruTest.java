package PacMan.objekty.mistaZmenySmeru;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Created by Admin on 20.5.2016.
 */
public class MistaZmenySmeruTest {
    @Test
    public void getOkraje() throws Exception {
        MistaZmenySmeru m = new MistaZmenySmeru(10, 15, 15, 10);
        assertEquals(new Rectangle(10, 15, 15, 10), m.getOkraje());
    }
}