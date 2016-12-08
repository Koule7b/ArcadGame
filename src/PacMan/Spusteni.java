/**
 * Autor: Štěpán Mudra
 */
package SemestralniProjektPacMan;

import VytvoreniUrovni.StepanoviUrovne;

/**
 * Tato třída má za úkol vytvořit instanci třídy Grafika a následně spustit nabídku s tlačítky.
 */
public class Spusteni {
    public static void main(String[] args) {
        StepanoviUrovne urovne = new StepanoviUrovne();
        urovne.vytvoreniUrovni();
        Grafika program = new Grafika();
        program.otevriNabidku();
    }
}
