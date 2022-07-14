package Egysegek;

import miez.Csatater;
import miez.Hos;

/**
 * A griff egy olyan egyseg amely akarhanyszor kepes visszatamadni
 *@version 1
 *@author Zsebedics Mark
 */
public class Griff extends Egyseg{
    public Griff() {
        super("Griff",15, new int[]{5,10}, 30, 7, 15);
    }
    public void vegtelenVisszatamadas(){}
    public static String reklam(){
        return "Griff, 15 aranyba kerul,30 az elete, 7 a sebessege, 15 a kezdemenyezese, 5-10 a sebzese";
    }


    // a griff minden csata utan visszanyeri a visszatamadas kepesseget
    @Override
    public void csatazik(Hos hosunk, Hos enemyHos, Egyseg enemy, Csatater csatater) {
        super.csatazik(hosunk, enemyHos, enemy, csatater);
        this.setVisszaTamad(true);
    }
}
