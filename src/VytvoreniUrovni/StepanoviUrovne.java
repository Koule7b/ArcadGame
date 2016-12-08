/**
 * Autor: Štěpán Mudra
 */
package VytvoreniUrovni;

import SemestralniProjektPacMan.objekty.Prekazka;
import SemestralniProjektPacMan.objekty.easterEgg.SkryteChodby;
import SemestralniProjektPacMan.objekty.easterEgg.SkrytyVchod;
import SemestralniProjektPacMan.objekty.jidlo.SuperJidlo;
import SemestralniProjektPacMan.objekty.jidlo.Svaca;
import SemestralniProjektPacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import SemestralniProjektPacMan.objekty.postavicky.Potvurka;
import SemestralniProjektPacMan.objekty.postavicky.Smery;
import SemestralniProjektPacMan.sluzby.VystaveniLevelu;
import SemestralniProjektPacMan.urovne.Uroven;

import java.awt.*;
import java.util.ArrayList;


public class StepanoviUrovne {
    public void vytvoreniUrovni(){
        VystaveniLevelu vystaveniLevelu = new VystaveniLevelu();
        vystaveniLevelu.ulozeniUrovne(0, vytvorUroven1());
        vystaveniLevelu.ulozeniUrovne(1, vytvorUroven2());
        vystaveniLevelu.ulozeniUrovne(2, vytvorUroven3());
        vystaveniLevelu.ulozeniUrovneSchovane(0, vytvorUroven4());
    }

    /**
     * public static Uroven vytvoreni(ArrayList<Prekazka> prekazky, ArrayList<MistaZmenySmeru> mista, ArrayList<Potvurka> potvurky, ArrayList<Svaca> svaca, ArrayList<SuperJidlo> superJidlo, ArrayList<SkryteChodby> skryteChodby, ArrayList<SkrytyVchod> skrytavchody, int urovne, Uroven uroven){
     * Uroven lvl = new Uroven(uroven.getBarvaVnitrku(), uroven.getBarvaVnitrku());
     * for (int i = 0; i < prekazky.size(); i++) {
     * lvl.addPrekazka();
     * }
     * }
     */
    private static Uroven vytvorUroven1() {
        Uroven lvl = new Uroven(Color.darkGray, Color.yellow);

        lvl.addPrekazka(30, 40, 90, 210);
        lvl.addPrekazka(150, 40, 120, 90);
        lvl.addPrekazka(150, 160, 120, 90);
        lvl.addPrekazka(30, 280, 240, 60);
        lvl.addPrekazka(30, 370, 125, 60);
        lvl.addPrekazka(180, 370, 90, 60);
        lvl.addPrekazka(30, 467, 240, 10);


        lvl.addPotvurka(70, 480, Smery.dolu);
        lvl.addPotvurka(270, 480, Smery.pravo);
        lvl.addPotvurka(160, 480, Smery.levo);
        lvl.addPotvurka(130, 480, Smery.levo);

        lvl.addMistoZnemySmeru(9, 260, 15, 15);
        lvl.addMistoZnemySmeru(9, 19, 15, 15);
        lvl.addMistoZnemySmeru(130, 19, 15, 15);
        lvl.addMistoZnemySmeru(280, 19, 15, 15);
        lvl.addMistoZnemySmeru(130, 140, 15, 15);
        lvl.addMistoZnemySmeru(280, 140, 15, 15);
        lvl.addMistoZnemySmeru(280, 260, 15, 15);
        lvl.addMistoZnemySmeru(280, 350, 15, 15);
        lvl.addMistoZnemySmeru(9, 350, 15, 15);
        lvl.addMistoZnemySmeru(130, 260, 15, 15);
        lvl.addMistoZnemySmeru(160, 350, 15, 15);
        lvl.addMistoZnemySmeru(160, 440, 15, 15);
        lvl.addMistoZnemySmeru(9, 440, 15, 15);
        lvl.addMistoZnemySmeru(280, 440, 15, 15);


        lvl.vytvoreniJidla();

        lvl.addSuperJidlo(195, 142);
        lvl.addSuperJidlo(250, 350);
        lvl.addSuperJidlo(163, 443);
        lvl.addSuperJidlo(15, 443);

        lvl.addSkryteChodby(50, 190, 70, 5);

        lvl.addSkrytyVchod(50, 190, 5);


        return lvl;

    }

    private static Uroven vytvorUroven2() {
        Uroven lvl = new Uroven(Color.YELLOW, Color.yellow);
        lvl.addPrekazka(53, 40, 20, 215);
        lvl.addPrekazka(70, 75, 100, 20);
        lvl.addPrekazka(100, 20, 174, 20);
        lvl.addPrekazka(200, 75, 20, 60);
        lvl.addPrekazka(254, 40, 20, 150);
        lvl.addPrekazka(100, 135, 70, 20);
        lvl.addPrekazka(100, 195, 125, 20);
        lvl.addPrekazka(200, 163, 25, 35);
        lvl.addPrekazka(27, 283, 20, 170);
        lvl.addPrekazka(230, 230, 25, 49);
        lvl.addPrekazka(107, 259, 125, 20);
        lvl.addPrekazka(40, 433, 227, 20);
        lvl.addPrekazka(250, 318, 20, 135);
        lvl.addPrekazka(200, 280, 20, 65);
        lvl.addPrekazka(130, 280, 20, 65);
        lvl.addPrekazka(77, 310, 20, 83);
        lvl.addPrekazka(97, 373, 130, 20);


        lvl.vytvoreniJidla();

        lvl.addPotvurka(150, 290, Smery.dolu);
        lvl.addPotvurka(170, 290, Smery.pravo);
        lvl.addPotvurka(150, 310, Smery.levo);
        lvl.addPotvurka(170, 310, Smery.levo);

        return lvl;
    }

    private static Uroven vytvorUroven3() {

        Uroven lvl = new Uroven(Color.WHITE, Color.WHITE);

        int pd = 19;
        lvl.addPrekazka(0, 0 + pd, 30, 90);
        lvl.addPrekazka(60, 60 + pd, 30, 60);
        lvl.addPrekazka(0, 150 + pd, 30, 90);
        lvl.addPrekazka(30, 270 + pd, 90, 30);
        lvl.addPrekazka(30, 330 + pd, 180, 30);
        lvl.addPrekazka(30, 390 + pd, 30, 60);
        lvl.addPrekazka(90, 180 + pd, 30, 30);

        // lvl.addPrekazka(90,210 + pd,120,30);
        lvl.addPrekazka(90, 210 + pd, 30, 30);
        lvl.addPrekazka(150, 210 + pd, 60, 30);

        lvl.addPrekazka(90, 390 + pd, 120, 30);
        lvl.addPrekazka(120, 90 + pd, 60, 30);
        lvl.addPrekazka(120, 360 + pd, 30, 30);
        lvl.addPrekazka(180, 30 + pd, 90, 30);
        lvl.addPrekazka(180, 120 + pd, 30, 90);
        lvl.addPrekazka(180, 240 + pd, 60, 60);
        lvl.addPrekazka(210, 60 + pd, 60, 30);
        lvl.addPrekazka(240, 0 + pd, 60, 30);
        lvl.addPrekazka(240, 120 + pd, 30, 90);
        lvl.addPrekazka(240, 330 + pd, 30, 150);
        lvl.addPrekazka(270, 180 + pd, 30, 30);
        lvl.addPrekazka(60, 150 + pd, 90, 30);
        lvl.addPrekazka(90, 450 + pd, 60, 30);
        lvl.addPrekazka(180, 420 + pd, 30, 30);


        lvl.vytvoreniJidla();

        int pp = 4;
        lvl.addPotvurka(0 + pp, 420 + pd, Smery.nahoru);
        lvl.addPotvurka(270 + pp, 420 + pd, Smery.nahoru);
        lvl.addPotvurka(0 + pp, 420 + pd, Smery.nahoru);
        lvl.addPotvurka(270 + pp, 30 + pd, Smery.dolu);
        lvl.addPotvurka(30 + pp, 10 + pd, Smery.pravo);

        pd = 19;
        pp += 3;
        lvl.addMistoZnemySmeru(30 + pp, 30 + pd, 1, 1);
        lvl.addMistoZnemySmeru(30 + pp, 90 + pd, 1, 1);
        lvl.addMistoZnemySmeru(30 + pp, 120 + pd, 1, 1);
        lvl.addMistoZnemySmeru(30 + pp, 180 + pd, 1, 1);
        lvl.addMistoZnemySmeru(0 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(0 + pp, 360 + pd, 1, 1);

        lvl.addMistoZnemySmeru(60 + pp, 0 + pd, 1, 1);
        lvl.addMistoZnemySmeru(60 + pp, 240 + pd, 1, 1);
        lvl.addMistoZnemySmeru(60 + pp, 360 + pd, 1, 1);
        lvl.addMistoZnemySmeru(90 + pp, 0 + pd, 1, 1);
        lvl.addMistoZnemySmeru(90 + pp, 60 + pd, 1, 1);
        lvl.addMistoZnemySmeru(90 + pp, 120 + pd, 1, 1);
        lvl.addMistoZnemySmeru(120 + pp, 0 + pd, 1, 1);
        lvl.addMistoZnemySmeru(120 + pp, 60 + pd, 1, 1);
        lvl.addMistoZnemySmeru(120 + pp, 240 + pd, 1, 1);
        lvl.addMistoZnemySmeru(120 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(150 + pp, 0 + pd, 1, 1);
        lvl.addMistoZnemySmeru(150 + pp, 60 + pd, 1, 1);
        lvl.addMistoZnemySmeru(150 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(210 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(210 + pp, 360 + pd, 1, 1);
        lvl.addMistoZnemySmeru(240 + pp, 210 + pd, 1, 1);
        lvl.addMistoZnemySmeru(240 + pp, 270 + pd, 1, 1);
        lvl.addMistoZnemySmeru(240 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(270 + pp, 90 + pd, 1, 1);
        lvl.addMistoZnemySmeru(270 + pp, 240 + pd, 1, 1);
        lvl.addMistoZnemySmeru(270 + pp, 300 + pd, 1, 1);
        lvl.addMistoZnemySmeru(60 + pp, 420 + pd, 1, 1);
        return lvl;
    }

    private static Uroven vytvorUroven4() {
        Uroven lvl = new Uroven(Color.DARK_GRAY, Color.BLUE);
        lvl.addPrekazka(30, 40, 60, 33);
        lvl.addPrekazka(210, 40, 60, 33);
        lvl.addPrekazka(120, 19, 60, 54);
        lvl.addPrekazka(30, 430, 60, 33);
        lvl.addPrekazka(210, 430, 60, 33);
        lvl.addPrekazka(120, 429, 60, 70);
        lvl.addPrekazka(0, 103, 90, 30);
        lvl.addPrekazka(209, 103, 90, 30);
        lvl.addPrekazka(0, 370, 90, 30);
        lvl.addPrekazka(209, 370, 90, 30);
        lvl.addPrekazka(30, 163, 30, 177);
        lvl.addPrekazka(240, 163, 30, 177);
        lvl.addPrekazka(120, 103, 60, 30);
        lvl.addPrekazka(120, 370, 60, 30);
        lvl.addPrekazka(90, 163, 120, 30);
        lvl.addPrekazka(90, 310, 120, 30);
        lvl.addPrekazka(90, 223, 30, 60);
        lvl.addPrekazka(150, 223, 60, 60);
        //102
        lvl.vytvoreniJidla();

        lvl.addSuperJidlo(10, 265);
        lvl.addSuperJidlo(280, 265);
        lvl.addPotvurka(0, 27, Smery.dolu);
        lvl.addPotvurka(279, 479, Smery.pravo);
        lvl.addPotvurka(270, 27, Smery.levo);
        lvl.addPotvurka(0, 477, Smery.levo);

        lvl.addMistoZnemySmeru(95, 75, 20, 20);
        lvl.addMistoZnemySmeru(185, 75, 20, 20);
        lvl.addMistoZnemySmeru(65, 135, 60, 20);
        lvl.addMistoZnemySmeru(185, 135, 60, 20);
        lvl.addMistoZnemySmeru(95, 400, 20, 20);
        lvl.addMistoZnemySmeru(185, 400, 20, 20);
        lvl.addMistoZnemySmeru(65, 350, 60, 20);
        lvl.addMistoZnemySmeru(185, 350, 60, 20);
        lvl.addMistoZnemySmeru(65, 195, 20, 20);
        lvl.addMistoZnemySmeru(215, 195, 20, 20);
        lvl.addMistoZnemySmeru(65, 285, 20, 20);
        lvl.addMistoZnemySmeru(215, 285, 20, 20);
        lvl.addMistoZnemySmeru(125, 195, 20, 20);
        lvl.addMistoZnemySmeru(125, 285, 20, 20);
        return lvl;
    }
}