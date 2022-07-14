package Egysegek;

import Egysegek.Egyseg;
import miez.Csatater;
import miez.Hos;

/**
 * az ijasz egy egyseg
 * @version 0.5
 * @author Zsebedics Mark
 */
public class Ijasz extends Egyseg {
    public Ijasz() {
        super("Ijasz",6, new int[]{2,4}, 7, 4, 9);
    }
    public void specko(){

    }
    public static String reklam(){
        return "Ijasz, 6 aranyba kerul,7 az elete, 4 a sebessege, 9 a kezdemenyezese, 2-4 a sebzese";
    }



}
