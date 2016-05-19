package PacMan.objekty.postavicky;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 19.5.2016.
 */
public class HracTest {
    @Test
    public void testBudouciPozicePravo(){
        Hrac h = new Hrac();
        h.setX(15);
        h.setY(15);
        h.setSmer(Smery.pravo);
        int [] pozice = h.budouciPozice();
        assertEquals(16, pozice[0]);
    }
    @Test
    public void testBudouciPoziceLevo(){
        Hrac h = new Hrac();
        h.setX(15);
        h.setY(15);
        h.setSmer(Smery.levo);
        int [] pozice = h.budouciPozice();
        assertEquals(14, pozice[0]);
    }
    @Test
    public void testBudouciPoziceNahoru(){
        Hrac h = new Hrac();
        h.setX(15);
        h.setY(15);
        h.setSmer(Smery.nahoru);
        int [] pozice = h.budouciPozice();
        assertEquals(14, pozice[1]);
    }
    @Test
    public void testBudouciPoziceDolu(){
        Hrac h = new Hrac();
        h.setX(15);
        h.setY(15);
        h.setSmer(Smery.dolu);
        int [] pozice = h.budouciPozice();
        assertEquals(16, pozice[1]);
    }
}