/**
 * Autor: Štěpán Mudra
 */
package PacMan.sluzby;

//import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Hrac;
import PacMan.objekty.postavicky.Postavicka;
import PacMan.objekty.postavicky.Potvurka;
import PacMan.objekty.postavicky.Smery;
import PacMan.urovne.Uroven;

import java.awt.*;
import java.util.Random;

/**
 * Třída Pohybovac má na starosti veškerý pohyb, kontrolu kolize -> i přičítání score.
 */
public class Pohybovac {
    // maximální velikost panelu
    private int maxSirka;
    private int maxVyska;

    //score
    private int scoreHrace;
    private int scorePotvurek;

    //zivoty
    private int zivoty;

    //instanční proměná Random
    private Random generator;

    //instanční proměná úrovně
    private Uroven uroven;

    /**
     * nastaví velikost hrací plochy, úroveň, životy, score dle parametrů, vytvoří novou instanci Random().
     * @param maxSirka
     * @param maxVyska
     * @param uroven
     * @param zivoty
     * @param scoreHrace
     * @param scorePotvurek
     */
    public Pohybovac(int maxSirka, int maxVyska, Uroven uroven, int zivoty, int scoreHrace, int scorePotvurek) {
        this.maxSirka = maxSirka;
        this.maxVyska = maxVyska;
        this.uroven = uroven;
        generator = new Random();
        this.zivoty = zivoty;
        this.scoreHrace = scoreHrace;
        this.scorePotvurek = scorePotvurek;
    }

    /**
     *Metoda, která generuje pravděpodobnost změny směru, následně i "náhodný" směr.
     * @param potvurka
     */
    public void nahodnySmer(Potvurka potvurka) {
        int nahoda = generator.nextInt(97) + 1;
        if (nahoda % (79) == 0) {
            Smery[] smer = Smery.values();
            potvurka.setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
        }
    }

    /**
     * Metoda která volá kontroly kolizí a následně pokud je cesta volná vším pohne.
     * Pokud cesta je neprůchodná, tak hráčem nepohne, potvůrkám přířadí "náhodný" směr.
     * Pokud hráč má cestu volnou, metoda ověrí, jestli je v kolizi s jídlem, pokud ano navýší score hráče o 1,
     * dále ověří, jestli hráč narazil do potvůrky, pokud ano nastaví výchozí souřadnice na aktuální,
     * sníží životy, přičte score potvůrkám, dále zkontroluje jestli hráč snědl superJidlo, pokud ano přičte ke score 30.
     * I u potvůrek je provedena kontrola snědení jídla, superjídla, navíc se u nich kontroluje i kolize s místem, kde mohou změnit směr.
     * Pokud jsou s tímto místem v kolizi zavolá se metoda nahodnySmer().
     */
    public void pohniVsim() {
        int[] budouci = uroven.getHrac().budouciPozice();
        if (!kontrolaKolizesOkrajemaHry(budouci[0], budouci[1], uroven.getHrac())) {
            if (!kontrolaKolizeSPrekazkama(budouci[0], budouci[1], uroven.getHrac()) || kontrolaSchodeb(budouci[0], budouci[1], uroven.getHrac())) {
                uroven.getHrac().Prebarveni(Color.LIGHT_GRAY);
                uroven.getHrac().pohyb();
                if (kontrolaSnedeniJidla(budouci[0], budouci[1], uroven.getHrac())) {
                    scoreHrace++;
                }
                /**
                 Nekontroluje kolizi hráče s potvůrkou, když hráč stojí.
                 Povoluje cheaty, když hráč stojí nenii sněden.
                 ;-)
                 */
                if (kontrolaKolizeSPotvurkama(budouci[0], budouci[1], uroven.getHrac())) {

                    zivoty--;
                    uroven.getHrac().setX(125);
                    uroven.getHrac().setY(230);
                    scorePotvurek = scorePotvurek + 30;
                }
                if (kontrolaKolizeSuperJidla(budouci[0], budouci[1], uroven.getHrac())) {
                    scoreHrace = scoreHrace + 30;
                }

            }else{
                uroven.getHrac().Prebarveni(Color.DARK_GRAY);
            }
        }else{
            uroven.getHrac().Prebarveni(Color.DARK_GRAY);
        }

        for (int i = 0; i < uroven.getPotvurky().size(); i++) {
            Potvurka potvurka = uroven.getPotvurky().get(i);
            if (kontrolaKolizeProZastaveni(potvurka)) {
                potvurka.pohyb();
            } else {
                Smery[] smer = Smery.values();

                potvurka.setSmer(smer[generator.nextInt(Smery.values().length - 1)]);
            }
            int[] budouciPotvurek = uroven.getPotvurky().get(i).budouciPozice();
            if (kontrolaKolizesMistem(budouciPotvurek[0], budouciPotvurek[1], uroven.getPotvurky().get(i))) {
                nahodnySmer(uroven.getPotvurky().get(i));
            }
            if (kontrolaSnedeniJidla(budouciPotvurek[0] - 1, budouciPotvurek[1] - 1, uroven.getPotvurky().get(i))) {
                scorePotvurek++;
            }
            if (kontrolaKolizeSuperJidla(budouciPotvurek[0], budouciPotvurek[1], uroven.getPotvurky().get(i))) {
                scorePotvurek = scorePotvurek + 30;
            }
        }
    }
    public boolean KontrolaVchodu(Hrac hrac){
        int[] budouci = uroven.getHrac().budouciPozice();
        for (int i = 0; i < uroven.getSkrytyVchod().size(); i++) {
            if (new Rectangle(budouci[0], budouci[1], uroven.getHrac().getVelikost(), uroven.getHrac().getVelikost()).intersects(uroven.getSkrytyVchod().get(i).getOkraje())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kontroluje kolizi, pro kterou je nutno postavičku zastavit (s překážkou a hrací plochou).
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizeProZastaveni(Postavicka postavicka) {
        int[] budouci = postavicka.budouciPozice();
        boolean kontrolaKolizeVOkne = kontrolaKolizesOkrajemaHry(budouci[0], budouci[1], postavicka);
        boolean kontrolaKolizePrekazky = kontrolaKolizeSPrekazkama(budouci[0], budouci[1], postavicka);
        return !kontrolaKolizeVOkne && !kontrolaKolizePrekazky;
    }

    /**
     * Pro každou potvůrku kontroluje kolizi s místem, kde může náhodně změnit směr.
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizesMistem(int x, int y, Potvurka postavicka) {
        for (int i = 0; i < uroven.getMistaZmenySmeru().size(); i++) {
            if (new Rectangle(x - 1, y - 1, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getMistaZmenySmeru().get(i).getOkraje())) {
                return true;
            }
        }
        return false;

    }

    /**
     * kontroluje kolizi postavicky (hráče s potvůrkami).
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizeSPotvurkama(int x, int y, Postavicka postavicka) {
        for (int i = 0; i < uroven.getPotvurky().size(); i++) {
            if (new Rectangle(x - 1, y - 1, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getPotvurky().get(i).getOkraje())) {
                return true;

            }
        }
        return false;
    }

    /**
     * Kontroluje kolizi s okrajem herní plochy. Y je omezeno na 19 z důvodu popisek (score.....).
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizesOkrajemaHry(int x, int y, Postavicka postavicka) {
        if ((x >= maxSirka - postavicka.getVelikost())) {
            return true;
        } else if ((y >= maxVyska - postavicka.getVelikost())) {
            return true;
        } else if (x < 1 || y < 19) {
            return true;
        }
        return false;
    }

    /**
     * kontroluje kolizi se superJidlem a odebira superJidlo v případě kolize.
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizeSuperJidla(int x, int y, Postavicka postavicka) {
        for (int i = 0; i < uroven.getSuperJidlo().size(); i++) {
            if (new Rectangle(x, y, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getSuperJidlo().get(i).getOkraje())) {
                uroven.getSuperJidlo().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * kontroluje kolizi s překážkama.
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaKolizeSPrekazkama(int x, int y, Postavicka postavicka) {
        for (int i = 0; i < uroven.getPrekazky().size(); i++) {
            if (new Rectangle(x - 1, y - 1, postavicka.getVelikost() + 2, postavicka.getVelikost() + 2).intersects(uroven.getPrekazky().get(i).getOkraje())) {
                return true;
            }
        }
        return false;
    }

    private boolean kontrolaSchodeb(int x, int y, Postavicka hrac){
        for (int i = 0; i < uroven.getSkryteChodby().size(); i++) {
            if(new Rectangle(x - 1, y - 1, hrac.getVelikost() + 2, hrac.getVelikost() + 2).intersects((uroven.getSkryteChodby().get(i).getOkraje()))){
                return true;
            }
        }
        return false;
    }

    /**
     *Metoda, která kontroluje snědení jídla postavičkou dle parametru.
     * @param x
     * @param y
     * @param postavicka
     * @return
     */
    private boolean kontrolaSnedeniJidla(int x, int y, Postavicka postavicka) {
        for (int i = 0; i < uroven.getSvaca().size(); i++) {
            Rectangle okrajeJidla = uroven.getSvaca().get(i).getOkraje();
            if (new Rectangle(x - 1, y - 2, postavicka.getVelikost(), postavicka.getVelikost()).intersects(okrajeJidla)) {
                uroven.getSvaca().remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda, která vrací score hráče.
     * @return
     */
    public int getScoreHrace() {
        return scoreHrace;
    }

    /**
     * Metoda, která vrací score potvůrek
     * @return
     */
    public int getScorePotvurek() {
        return scorePotvurek;
    }

    /**
     * Metoda, která vrací životy
     * @return
     */
    public int getZivoty() {
        return zivoty;
    }
}
