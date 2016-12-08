/**
 * Autor: Štěpán Mudra
 */
package PacMan.okna;

import PacMan.Grafika;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Nabidka je panel, který umožňuje zvojit, jestli hru chci spustit, nebo vypnout, implementuje ActionListener.
 */
public class Nabidka extends JPanel implements ActionListener {
    //instanční proměná grafiky
    private Grafika okno;

    //proměné typu string, kterépopisují tlačítko.
    final private String TLACITKO_SPUSTIT = "Spustit";
    final private String TLACITKO_VYPNOUT = "Vypnout";

    /**
     * nastaví barvu za tlačítky vytvoří tlačítka, přidá je na panel a přiřadí privátní peoměné "okno" parametr.
     * @param okno
     */
    public Nabidka(Grafika okno) {
        setBackground(Color.BLUE);

        Button start = new Button(TLACITKO_SPUSTIT);
        Button vypnout = new Button(TLACITKO_VYPNOUT);
        add(start);
        add(vypnout);
        start.addActionListener(this);
        vypnout.addActionListener(this);
        this.okno = okno;
    }

    /**
     * Přetížením metody actionPerformed(ActionEvent ae) nastavím funkce tlačítkům.
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String pri = ae.getActionCommand();
        if (pri.equals(TLACITKO_SPUSTIT)) {
            okno.otevriHru();
        }
        if (pri.equals(TLACITKO_VYPNOUT)) {
            okno.dispose();
        }
    }
}
