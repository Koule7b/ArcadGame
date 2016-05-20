package PacMan;

import PacMan.objekty.postavicky.Smery;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 20.5.2016.
 */
public class EngineTest {
    @Test
    public void konecLevelu() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(false, e.konecLevelu());
    }

    @Test
    public void getScoreHrace() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(0, e.getScoreHrace());
    }

    @Test
    public void getScorePotvurek() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(0, e.getScorePotvurek());
    }

    @Test
    public void getZivotyHrace() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(3, e.getZivotyHrace());
    }

    @Test
    public void konecHry() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(false, e.KonecHry());
    }

    @Test
    public void hracVyhral() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(false, e.HracVyhral());
    }

    @Test
    public void nactiUroven() throws Exception {
        Engine e = new Engine(300, 500);
        assertEquals(true, e.nactiDalsiUroven());
    }

}