package Egysegek;

import miez.Csatater;
import miez.Hos;
/**
 *A sarkany egy egyseg amely kepes ket egymas mogott allo ellenseget is megsebezni a tamadasnal
 * @version 1
 * @author Zsebedics Mark
 */
public class Sarkany extends Egyseg{
    public Sarkany(){
        super("sarkany",35,new int[]{10, 15},75,12,5);
    }
    public static String reklam(){
        return "Sarkany, 35 aranyba kerul,70 az elete, 12 a sebessege, 5 a kezdemenyezese, 10-15 a sebzese";
    }

    public void csatazik(Hos hosunk, Hos enemyHos, Egyseg enemy, Csatater csatater){
        int max = this.getSebzes()[1];
        int min = this.getSebzes()[0];
        int range = max - min + 1;
        int sebzes = 0 ;
        int random = (int)(Math.random()*range)+min;
        sebzes = this.getLetszam() *random;
        sebzes *= (hosunk.getTamadas()/100+1);
        sebzes -= (enemyHos.getVedekezes()/100*5);
        if(hosunk.getSzerencse()*0.05>Math.random()){
            sebzes *=2 ;
            System.out.println("KRITIKUS TALALAT!!!  "+sebzes);
        }else{
            System.out.println("Sebzes "+sebzes);
        }

        int hallottak = sebzes / enemy.getEletero();
        int sebesult = sebzes % enemy.getEletero();
        enemy.setLetszam(enemy.getLetszam()-hallottak);

        String[] trimmEltEgysegPosition = enemy.getKoordinata().strip().split(",");
        int enemyX = Integer.parseInt(trimmEltEgysegPosition[0]);
        int enemyY = Integer.parseInt(trimmEltEgysegPosition[1]);
        String[] trimmEltEgysegPosition2 = this.getKoordinata().strip().split(",");
        int playerX = Integer.parseInt(trimmEltEgysegPosition2[0]);
        int playerY = Integer.parseInt(trimmEltEgysegPosition2[1]);

        String melyikOldalrolLehet ="";
        if(enemyX+1==playerX){
            if(csatater.mezok[enemyX-1][enemyY]!=null){
                csatater.mezok[enemyX-1][enemyY].setVisszaTamad(false);
                csatazik(hosunk,enemyHos,csatater.mezok[enemyX-1][enemyY],csatater);
            }
        }
        if(enemyX-1==playerX){
            if(csatater.mezok[enemyX+1][enemyY]!=null){
                csatater.mezok[enemyX+1][enemyY].setVisszaTamad(false);
                csatazik(hosunk,enemyHos,csatater.mezok[enemyX+1][enemyY],csatater);
            }
        }if(enemyY+1==playerY){
            if(csatater.mezok[enemyX][enemyY-1]!=null){
                csatater.mezok[enemyX][enemyY-1].setVisszaTamad(false);
                csatazik(hosunk,enemyHos,csatater.mezok[enemyX][enemyY-1],csatater);
            }
        }
        if(enemyY-1==playerY){
            if(csatater.mezok[enemyX][enemyY+1]!=null){
                csatater.mezok[enemyX][enemyY+1].setVisszaTamad(false);
                csatazik(hosunk,enemyHos,csatater.mezok[enemyX][enemyY+1],csatater);
            }
        }



        if(enemy.isHalott()){
            return;
        }

        if(enemy.isVisszaTamad()) {
            sebzes = 0;
            max = enemy.getSebzes()[1];
            min = enemy.getSebzes()[0];
            random = (int) (Math.random() * range) + min;
            sebzes = enemy.getLetszam() * random;
            sebzes *= (enemyHos.getTamadas() / 100 + 1);
            sebzes -= (hosunk.getVedekezes() / 100 * 5);
            sebzes/=2;
            if (enemyHos.getSzerencse() * 0.05 > Math.random()) {
                sebzes *= 2;
                System.out.println("KRITIKUS VISZATAMADAS!!!  " + sebzes);
            } else {
                System.out.println("Visszatamadas  " + sebzes);
            }

            hallottak = sebzes / this.getEletero();
            this.setLetszam(this.getLetszam() - hallottak);
            enemy.setVisszaTamad(false);
        }

        if(enemyX+1!=playerX ||  enemyX-1!=playerX ||   enemyY-1!=playerY ||  enemyY+1!=playerY){
        setVisszaTamad(true);
    }
    }

}
