/**
 * Autor: Štěpán Mudra
 */
package SemestralniProjektPacMan;

import SemestralniProjektPacMan.okna.Hra;
import SemestralniProjektPacMan.okna.Nabidka;

import javax.swing.*;

/**
 * Třída Grafika si vytvoří okno do kterého pomocí metody "otevriNabidku()" promítne nabídku a pomocí "otevriHru()" promítne hru.
 */
public class Grafika extends JFrame {
    //instanční proměná nabídky, která se přidá do okna.
    private Nabidka nabidka;
    //instanční proměná hry, která bude umístěna časem v okně
    private Hra hra;

    public Grafika() {
        setTitle("Hra_Semestrální_Projekt");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        return;
    }

    /**
     * Metoda níže vytvoří novou instanci nabídku a přidá ji do okna, následně velikost okna upraví pomocí "pack()" a nastaví viditelnost na true.
     */
    public void otevriNabidku() {
        nabidka = new Nabidka(this);
        add(nabidka);
        pack();
        this.setVisible(true);
    }

    /**
     * Metoda "otevriHru()" dělá totéž jako metoda "otevriNabidku()" jen místo s nabídkou s hrou jako takovou.
     * Ještě jako dpolnění přidá hře focus pomocí "hra.requestFocus()", jinak by focus měla nabídka a nefungovala by ve hře
     * anonymní třída keyListener.
     */
    public void otevriHru() {
        nabidka.setVisible(false);
        hra = new Hra();
        add(hra);
        pack();
        hra.requestFocus();
        this.setVisible(true);
    }
}
