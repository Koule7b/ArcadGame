package PacMan.sluzby;

import PacMan.urovne.Uroven;

import java.io.*;

/**
 * Třída, která má za úkol vystavět levely, zapsat do souboru, poté je i načíst :-)
 */
public class VystavenyLevelu {

    /**
     * ukládá úroveň do souboru úroveň pojmenuje dle indexace.
     * @param i
     * @param uroven
     */
    public void ulozeniUrovne(int i, Uroven uroven) {
        try {
            FileOutputStream fileOut = new FileOutputStream("urovne/"+i+".bin");

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(uroven);
            out.close();
            fileOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * načte úroveň podle parametru.
     * @param cisloUrovne
     * @return
     */
    public Uroven nacti(int cisloUrovne)
    {
        Uroven uroven = null;
        try {
            FileInputStream fileIn = new FileInputStream("urovne/"+cisloUrovne+".bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            uroven = (Uroven) in.readObject();
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            // file not found, creating new board
            System.out.println("board: new file will be created");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return uroven;
    }
}
