package PacMan.okna;


import PacMan.objekty.Prekazka;
import PacMan.objekty.jidlo.SuperJidlo;
import PacMan.objekty.jidlo.Svaca;
import PacMan.objekty.mistaZmenySmeru.MistaZmenySmeru;
import PacMan.objekty.postavicky.*;
import PacMan.Engine;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.ImageIcon;

/**
 * Author: Štěpán Mudra.
 * Třída hra rozšiřuje/dědí z třídy JPanel, takže se v okně vytvoří panel s hrou.
 */
public class Hra extends JPanel {
    private Engine engine;
    private Timer casovac;
    private Image gameoverP = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\Hra\\src\\Pac - Man.jpg").getImage();

    /**
     * Konstruktor třídy hra nastaví velikost panelu 300x500 (sirka x vyska)
     * Vytvoří novou instanci vnitří třídy "PoslouchaniCasovace()", která se jmenuje publikum.
     * Nastaví instanci třídy "Timer", čas obnovení a kdo se má obnovovat, spustí "Timer".
     * Určí preferovanou šírku výšku "this.setPreferredSize(new Dimension(sirka, vyska))".
     * Přiřadí instanci třídy "Engine" smysl a vloží do ní nový Engine, kterému pomocí parametrů předá velikost panelu.
     * Nastaví barvu pozadí na šedou.
     * Pomocí vnitřní anonymní třídy mění podle zmačknutého tlačítka novySmer a pokud novySmer != null, tak zavola "engine.zmenSmer(novySmer)"
     */
    public Hra() {
        int sirka = 300;
        int vyska = 500;
        PoslouchaniCasovace publikum = new PoslouchaniCasovace();
        casovac = new Timer(10, publikum);
        casovac.start();
        this.setPreferredSize(new Dimension(sirka, vyska));
        this.engine = new Engine(sirka, vyska);
        this.setBackground(Color.DARK_GRAY);


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                Smery novySmer = null;
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W :
                    case KeyEvent.VK_UP :
                        novySmer = Smery.nahoru; break;
                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:
                        novySmer = Smery.dolu; break;
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:
                        novySmer = Smery.levo; break;
                    case KeyEvent.VK_D:
                    case KeyEvent.VK_RIGHT:
                        novySmer = Smery.pravo; break;
                }
                if(novySmer != null){
                    engine.zmenSmer(novySmer);
                }
            }
        });
    }

    /**
     * Metoda která má za úkol vykreslit hrací plochu a překreslovat ji.
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Kontroluje jeslti nastal konec hry.
        if (engine.KonecHry()) {
            //pokud ano, tak zkoumá, kdo vyhrál, pokd hráč, tak vykreslí výhru, pokud nevyhrál hráč -> vyhrály potvůrky a vykreslí prohru, v každém případě stopne časovač.
             if(engine.HracVyhral()) {
             vypisVyhru(g);
             casovac.stop();
             }else{
             vypsaniProhry(g);
             casovac.stop();
             }
        }else {
            pocetZivotu(g);
            vypisScore(g);
            if (engine.getZivotyHrace() <= 0) {
                vypsaniProhry(g);
                casovac.stop();
                return;
            }

            vykresliPromene(g);
        }

    }

    /**
     * metoda, která vykresluje všechny objekty na hrací ploše.
     * @param g
     */
    private void vykresliPromene(Graphics g) {
        ArrayList<Svaca> jidlo = engine.getSvaca();
        for (int i = 0; i < jidlo.size(); i++) {
            jidlo.get(i).vykresliSe(g);
        }

        engine.getHrac().vykresliSe(g);

        ArrayList<Potvurka> potvurky = engine.getPotvurky();
        for (int i = 0; i < potvurky.size() ; i++) {
            potvurky.get(i).vykresliSe(g);
        }
        ArrayList<Prekazka> prekazkay = engine.getPrekazky();
        for (int i = 0; i < prekazkay.size(); i++) {
            prekazkay.get(i).vykresliSe(g);
        }
        ArrayList<SuperJidlo> superJidlo = engine.getSuperJidlo();
        for (int i = 0; i < superJidlo.size(); i++) {
            superJidlo.get(i).vykresleniSuperJidla(g);
        }
        /**
         * tato čáat je zakomentovaná, protože finální uživatel vidět místa, kde "potvůrky" mohou změnit směr nemá,
         * je zde jen a pouze jako pomůcka, když jsem přidával místa pro změnu směru.
        ArrayList<MistaZmenySmeru> mistaZmenySmeru = engine.getMistaZmenySmeru();
        for (int i = 0; i < mistaZmenySmeru.size() ; i++) {
            mistaZmenySmeru.get(i).vykresliSe(g);
        }
         */
    }

    /**
     * metoda vypisujici score
     * @param g
     */
    private void vypisScore(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawString("Score Hrace: "+String.valueOf(engine.getScoreHrace()), 200, 15);
        g.drawString("Score Potvurek: "+String.valueOf(engine.getScorePotvurek()), 15, 15);
    }

    /**
     * metoda vykreslujici vyhru
     * @param g
     */
    private void vypisVyhru(Graphics g) {
        //this.setBackground(Color.BLUE);
        g.setColor(Color.ORANGE);
        g.drawImage(gameoverP,0,19,this);
        //g.drawString("V Y H R Á L / A  J S I .", 90, 270);
    }

    /**
     * metoda vykreslujici prohru
     * @param g
     */
    private void vypsaniProhry(Graphics g) {
        g.setColor(Color.orange);
        g.drawString("P A R D O N ,  A L E  G A M E  O V E R .", 70, 270);
    }

    /**
     * metoda vypisujici pocet zivotu
     * @param g
     */
    private void pocetZivotu(Graphics g) {
        g.setColor(Color.YELLOW);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString("ZIVOTY :   " + engine.getZivotyHrace(), 125, 15);
    }

    /**
     * vnitřní anonymní třída, která na povel casovace provede veskere zmeny stavu, pokud jsou a prekresli panel.
     */
    private class PoslouchaniCasovace implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            engine.skok();
            if(engine.konecLevelu()){
                engine.nactiDalsiUroven();
            }
            repaint();
        }
    }
}