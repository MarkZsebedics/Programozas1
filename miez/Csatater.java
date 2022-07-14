package miez;

import Egysegek.Egyseg;

import java.util.Arrays;

/**
 *  @version 1
 *  @author Zsebedics Mark
 *  A terulet amelyen az egysegek elhelyezkednek
 */
public class Csatater {
    public Egyseg[][] mezok;


    public Csatater() {
        this.mezok = new Egyseg[10][12];
    }

    public Csatater(Egyseg[][] mezok) {
        this.mezok = mezok;
    }

    @Override
    public String toString() {
        String szoveg = "";
        for (int i = 0; i < mezok.length ; i++) {
            for (int j = 0; j < mezok[i].length ; j++) {
                szoveg += " "+ mezok[i][j];
            }
            szoveg+="\n";
        }
        return szoveg;
    }
}
