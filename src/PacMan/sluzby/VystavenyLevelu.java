package PacMan.sluzby;

import PacMan.Engine;
import PacMan.objekty.postavicky.Smery;
import PacMan.urovne.Uroven;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Admin on 4.4.2016.
 */
public class VystavenyLevelu {
    private ArrayList<Uroven> sezanam = new ArrayList<>();
    public int getPocetLevelu(){return sezanam.size();}

    public VystavenyLevelu() {
    }



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
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
        return uroven;
    }
}
