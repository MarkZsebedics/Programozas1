package miez;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import Egysegek.Egyseg;
import Varazslatok.Varazslat;

/**
 * Hos osztaly
 * @author Zsebedics Mark
 * @version 0.12
 * A jatekban megmerkozo hosoket prezentalja.
 */
public class Hos {
    private int tamadas;
    private int vedekezes;
    private int varazsero;
    private int tudas;
    private int moral;
    private int szerencse;
    private int tudaspontAr;
    private int arany;
    private LinkedList<Egyseg> sereg;
    private int mana ;
    private boolean tudlepni;
    private LinkedList<Varazslat> varazskonyv;

    /**
     * A hos konstruktora, amely parameter nelkul inicializalja a kezdo Hos ertekere, mindenki innnen indul.
     * @author Zsebedics Mark
     */
    public Hos() {

        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.tudaspontAr = 5;
        this.sereg = new LinkedList<Egyseg>();
        this.varazskonyv = new LinkedList<Varazslat>();

    }

    public boolean isTudlepni() {
        return tudlepni;
    }

    public void setTudlepni(boolean volteMar) {
        this.tudlepni = volteMar;
    }

    public LinkedList<Egyseg> getSereg() {
        return sereg;
    }

    public void setSereg(LinkedList<Egyseg> sereg) {
        this.sereg = sereg;
    }

    public LinkedList<Varazslat> getVarazskonyv() {
        return varazskonyv;
    }

    public void setVarazskonyv(LinkedList<Varazslat> varazskonyv) {
        this.varazskonyv = varazskonyv;
    }

    public int getTamadas() {
        return tamadas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public int getMoral() {
        return moral;
    }

    public int getSzerencse() {
        return szerencse;
    }

    public int getTudaspontAr() {
        return tudaspontAr;
    }

    public void setTamadas(int tamadas) {
        this.tamadas = tamadas;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes = vedekezes;
    }

    public void setVarazsero(int varazsero) {
        this.varazsero = varazsero;
    }

    public void setTudas(int tudas) {
        this.tudas = tudas;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse = szerencse;
    }

    public void setTudaspontAr(int tudaspontAr) {
        this.tudaspontAr = tudaspontAr;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void addTamadas(){
        if(this.getTamadas()==10){
            System.err.println("Mar 10en van a tamadasod ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){
            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.tamadas++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Tamadasod 1-el nott");
    }

    public void addVarazsero(){
        if(this.getVarazsero()==10){
            System.err.println("Mar 10en van a varazserod ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){
            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.varazsero++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Varazserod 1-el nott");
    }

    public void addTudas(){
        if(this.getTudas()==10){
            System.err.println("Mar 10en van a tudasod ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){

            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.tudas++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Tudasod 1-el nott");
    }

    public void addMoral(){
        if(this.getMoral()==10){
            System.err.println("Mar 10en van a moralod ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){
            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.moral++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Moralod 1-el nott");
    }

    public void addSzerencse(){
        if(this.getSzerencse()==10){
            System.err.println("Mar 10en van a szerencsed ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){
            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.szerencse++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Szerencsed 1-el nott");
    }

    public void addVedekezes(){
        if(this.getVedekezes()==10){
            System.err.println("Mar 10en van a vedekezesed ami a max!");
            return;
        }
        if(this.tudaspontAr>this.arany){
            System.err.println("nincs eleg aranyad a tudaspontra!");
            return;
        }
        this.arany -= this.tudaspontAr;
        this.vedekezes++;
        this.tudaspontAr = (int)Math.ceil(this.tudaspontAr*1.1);
        System.out.println("Vedekezesed 1-el nott");
    }

    public void setArany(int arany) {
        this.arany = arany;
    }

    public int getArany() {
        return arany;
    }
}
