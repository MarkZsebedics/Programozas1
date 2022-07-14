package Egysegek;

import miez.Csatater;
import miez.Hos;

/**
 * @version 1
 * @author Zsebedics Mark
 * A vampirur egy olyan egyseg amely mindig visszatud tamadni, viszont ellene senki se kepes visszatamadni
 */
public class VampirUr extends Egyseg{
    public VampirUr() {
        super("VampirUr",25, new int[]{3,7}, 20, 6, 3);
    }
    public void vegtelenVisszatamadas(){}
    public static String reklam(){
        return "VampirUr, 25 aranyba kerul,20 az elete, 6 a sebessege, 3 a kezdemenyezese, 3-7 a sebzese";
    }



    @Override
    public void csatazik(Hos hosunk, Hos enemyHos, Egyseg enemy, Csatater csatater) {
        int max = this.getSebzes()[1];
        int min = this.getSebzes()[0];
        int range = max - min + 1;
        int sebzes = 0 ;
        int random = (int)(Math.random()*range)+min;
        sebzes = this.getLetszam()*random;
        sebzes *= (hosunk.getTamadas()/100+1);
        sebzes -= (enemyHos.getVedekezes()/100*5);
        if(hosunk.getSzerencse()*0.05>Math.random()){
            sebzes *=2 ;
            System.out.println("KRITIKUS TALALAT!!!  "+sebzes);
        }else{
            System.out.println("Sebzes "+sebzes);
        }

        int hallottak = sebzes / enemy.getEletero() ;
        int sebesult = sebzes % enemy.getEletero();
        enemy.setLetszam(enemy.getLetszam()-hallottak);


    }
}
