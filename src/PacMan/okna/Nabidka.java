package PacMan.okna;

import PacMan.Grafika;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Nabidka je panel, který umožňuje zvojit, jestli hru chci spustit, nebo vypnout
 */
public class Nabidka extends JPanel implements ActionListener {
    private Grafika okno;
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
     * Vnitřní anonymní třída, která se stará o akce tlačítek, když zmáčku spustit otevře hru, když vypnout zavře okno a vypne se.
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
