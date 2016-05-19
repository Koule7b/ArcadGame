package PacMan.urovne;

import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Smery;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Admin on 19.5.2016.
 */
public class UrovenTest {
    @Test
    public void getPrekazky() throws Exception {
        Uroven u = new Uroven(Color.red, Color.yellow);
        u.addPrekazka(5, 5, 15, 15);
        ArrayList<Prekazka> prekazky = u.getPrekazky();
        assertEquals(1, prekazky.size());
    }

    @Test
    public void getPotvurky() throws Exception {
        Uroven u = new Uroven(Color.red, Color.yellow);
        u.addPotvurka(5, 5, Smery.pravo);
        ArrayList<Potvurka> potvurky = u.getPotvurky();
        assertEquals(1, potvurky.size());
    }

    @Test
    public void getSvaca() throws Exception {
        Uroven u = new Uroven(Color.red, Color.yellow);
        u.vytvoreniJidla();
        ArrayList<Svaca> jidlo = u.getSvaca();
        assertEquals(160, jidlo.size());
    }

    @Test

    public void getSuperJidlo() throws Exception {
        Uroven u = new Uroven(Color.red, Color.yellow);
        u.addSuperJidlo(5, 5);
        ArrayList<SuperJidlo> superJidlo = u.getSuperJidlo();
        assertEquals(1, superJidlo.size());
    }
    @Test
    public void getMistoZmenySmeru() throws Exception {
        Uroven u = new Uroven(Color.red, Color.yellow);
        u.addMistoZnemySmeru(5, 5, 15, 15);
        ArrayList<MistaZmenySmeru> mistaZmenySmeru = u.getMistaZmenySmeru();
        assertEquals(1, mistaZmenySmeru.size());
    }
}