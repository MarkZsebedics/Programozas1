package Egysegek;

import java.beans.EventHandler;
import java.util.Arrays;
import miez.Csatater;
import miez.Hos;

/**
 * Az egyseg osztaly amibol peldanyositva lesznek az egysegek amikkel lepkedunk a csatamezon
 * @version 1.-
 * @author Zsebedics Mark
 *
 */
public class Egyseg implements Comparable<Egyseg> {
    String nev;
    private int ar;
    private int[] sebzes;
    private int eletero;
    private int sebesseg;
    private int kezdemenyezes;
    private int letszam;
    private String koordinata;
    private boolean visszaTamad;

    public boolean isVisszaTamad() {
        return visszaTamad;
    }

    public void setVisszaTamad(boolean visszaTamad) {
        this.visszaTamad = visszaTamad;
    }

    public Egyseg(String nev, int ar, int[] sebzes, int eletero, int sebesseg, int kezdemenyezes) {
        this.nev = nev;
        this.ar = ar;
        this.sebzes = sebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
    }

    public String getKoordinata() {
        return koordinata;
    }

    public void setKoordinata(String koordinata) {
        this.koordinata = koordinata;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int[] getSebzes() {
        return sebzes;
    }

    public void setSebzes(int[] sebzes) {
        this.sebzes = sebzes;
    }

    public int getEletero() {
        return eletero;
    }

    public void setEletero(int eletero) {
        this.eletero = eletero;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }

    public int getKezdemenyezes() {
        return kezdemenyezes;
    }

    public void setKezdemenyezes(int kezdemenyezes) {
        this.kezdemenyezes = kezdemenyezes;
    }

    public int getLetszam() {
        return letszam;
    }

    public void setLetszam(int letszam) {
        this.letszam = letszam;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public boolean mozgas(int x, int y, Csatater map){
        String[] trimmEltEgysegPosition = this.koordinata.strip().split(",");

        int iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
        int ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
        if(x>9 || x<0){
            System.err.println("maprol csak ne menj mar ki");
            return false;}
        if(y>11 || y<0){
            System.err.println("maprol csak ne menj mar ki");
            return false;}
        if(map.mezok[x][y]!=null){
           // System.err.println("Nem gombaazhatod meg az egysegeket!!!"); ha odalepett ahol voltak akkor felurirta a helyet
            // ezaltal oneshotolta. Mint mario a goombakat :) enemy random valaszt helyet, szoval ezt folyamat dobna
            return false;
        }

        int tavolsag = 0 ;
        tavolsag+= Math.abs(Math.abs(x)-Math.abs(iksz));
        tavolsag+= Math.abs(Math.abs(y)-Math.abs(ipszilon));
        if(tavolsag<=this.sebesseg){
            map.mezok[x][y] = this ;
            map.mezok[iksz][ipszilon] = null;
            this.koordinata = x+","+y;
            return true;
        }
        return false;
    }

    public void csatazik(Hos hosunk,Hos enemyHos, Egyseg enemy, Csatater csatater){
        int max = this.sebzes[1];
        int min = this.sebzes[0];
        int range = max - min + 1;
        int sebzes = 0 ;
        int random = (int)(Math.random()*range)+min;
        sebzes = this.letszam*random;
        sebzes *= (hosunk.getTamadas()/100+1);
        sebzes -= (enemyHos.getVedekezes()/100*5);
        if(hosunk.getSzerencse()*0.05>Math.random()){
            sebzes *=2 ;
            System.out.println(this.nev + "Kritikus sebzest adott, "+enemy.nev+", "+sebzes +"-el");
        }else{
            System.out.println(this.nev + "sebzest adott, "+enemy.nev+", "+sebzes +"-el");
        }

        int hallottak = sebzes / enemy.eletero ;
        int sebesult = sebzes % enemy.eletero;
        enemy.setLetszam(enemy.getLetszam()-hallottak);
        if(enemy.isHalott()){
            return;
        }
        if(enemy.isVisszaTamad()) {
            sebzes = 0;
            max = enemy.sebzes[1];
            min = enemy.sebzes[0];
            random = (int) (Math.random() * range) + min;
            sebzes = enemy.letszam * random;
            sebzes *= (enemyHos.getTamadas() / 100 + 1);
            sebzes -= (hosunk.getVedekezes() / 100 * 5);
            sebzes/=2;
            if (enemyHos.getSzerencse() * 0.05 > Math.random()) {
                sebzes *= 2;
                System.out.println("KRITIKUS VISZATAMADAS!!!  " + sebzes);
            } else {
                System.out.println("Visszatamadas  " + sebzes);
            }

            hallottak = sebzes / this.eletero;
            this.setLetszam(this.getLetszam() - hallottak);
            enemy.visszaTamad = false;
        }
    }


    public boolean isHalott(){
        if(this.letszam<=0){
            return true;
        }
        return false;
    }


    @Override
    public boolean equals(Object e){
        if(!(e instanceof Egyseg)) return false;
        Egyseg obj = (Egyseg) e;
        if(this.getNev().equals(obj.getNev())){
            return true;
        }else return false;
    }
    public int compareTo(Egyseg egyseg){
        if(this.kezdemenyezes == egyseg.kezdemenyezes)return 0;
        else if(this.kezdemenyezes > egyseg.kezdemenyezes) return -1;
        else return 1;
    }

    @Override
    public int hashCode(){
        return this.getNev().hashCode() * 37;
    }

    @Override
    public String toString() {
        return
               /* ", ara=" + ar +
                ", sebzese=" + Arrays.toString(sebzes) +
                ", eletereje=" + eletero +
                ", sebessege=" + sebesseg +
                ", kezdemenyezese=" + kezdemenyezes +*/
                 letszam + " "+ nev;
    }
}
