import Egysegek.*;
import Varazslatok.*;
import miez.Csatater;
import miez.Hos;
import java.util.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Objektumok inicializasa

        Hos jatekos = new Hos();
        Foldmuves janos = new Foldmuves();
        Ijasz Robin = new Ijasz();
        Griff elfuseraltSas = new Griff();
        Sarkany bigGyik = new Sarkany();
        VampirUr verszittya = new VampirUr();
        Csatater csatater = new Csatater();
        Varazslat villam =  new Villamcsapas();
        Varazslat tuzlabda =  new Tuzlabda();
        Varazslat felelesztes =  new Feltamasztas();
        Varazslat siettseg = new Siettseg();
        Banat banat = new Banat();

        Hos igaziMestersegesIntelligencia = new Hos();
        Foldmuves jozsef = new Foldmuves();
        jozsef.setLetszam(150);
        jozsef.setNev("paraszt");
        Ijasz telVilmos = new Ijasz();
        telVilmos.setLetszam(80);
        telVilmos.setNev("ijasz");
        Griff torzGalamb1 = new Griff();
        torzGalamb1.setLetszam(20);
        torzGalamb1.setNev("griffin");

        //Ai init, hadsereg feltoltese
        igaziMestersegesIntelligencia.getSereg().add(jozsef);
        igaziMestersegesIntelligencia.getSereg().add(telVilmos);
        igaziMestersegesIntelligencia.getSereg().add(torzGalamb1);
        igaziMestersegesIntelligencia.setMoral(5);
        igaziMestersegesIntelligencia.setSzerencse(3);
        igaziMestersegesIntelligencia.setTamadas(5);
        igaziMestersegesIntelligencia.setTudas(2);
        igaziMestersegesIntelligencia.setVarazsero(2);
        igaziMestersegesIntelligencia.setVedekezes(7);

        Scanner nehezegScan = new Scanner(System.in);
        boolean whileVar = true;

        //Nehezseg beallitasa
        while (whileVar){
            System.out.println("Valasz nehezseget! (easy/medium/hard)");
            String nehezseg = nehezegScan.nextLine();
            switch (nehezseg.toLowerCase()){
            case "easy":
                jatekos.setArany(1300);
                whileVar = false;
                break;
            case "medium":
                jatekos.setArany(1000);
                whileVar = false;
                break;
            case "hard":
                jatekos.setArany(700);
                whileVar = false;
                break;
            default:
                jatekos.setArany(1000);
                System.err.println("Na hat ilyen nehezseg a vilagon nincs");
        }}
            //Vasarlasi fazis megkezdese
            while(true){
            System.out.println("Udv a tescoban!\nHa skillpontot ohajtasz vasarolni akkor a kovetkezo "
                    + jatekos.getTudaspontAr()
                    + " ba kerul.");


                System.out.println("Milyen skillpontot szeretnel venni? ('0', ha semmit)" +
                        "\nTamadas ("+jatekos.getTamadas()+")\t" +
                        "Vedekezes ("+jatekos.getVedekezes()+")\t" +
                        "Varazsero ("+jatekos.getVarazsero()+")\t" +
                        "Tudas ("+jatekos.getTudas()+")\t" +
                        "Moral ("+jatekos.getMoral()+")\t" +
                        "Szerencse ("+jatekos.getSzerencse()+")\t");

                String skillValaszt2 = nehezegScan.nextLine();
                switch (skillValaszt2.toLowerCase()) {
                    case "tamadas":
                        jatekos.addTamadas();
                        break;
                    case "vedekezes":
                        jatekos.addVedekezes();
                        break;
                    case "varazsero":
                        jatekos.addVarazsero();
                        break;
                    case "tudas":
                        jatekos.addTudas();
                        break;
                    case "moral":
                        jatekos.addMoral();
                        break;
                    case "szerencse":
                        jatekos.addSzerencse();
                        break;
                    case "0":
                        break;
                    default:
                        System.err.println("Elgepelted");
                }
                if (skillValaszt2.equalsIgnoreCase("0")) {
                    break;
                }
            }

            //EgysegVasarlasi resz
                while (true) {
                    System.out.println(Foldmuves.reklam());
                    System.out.println(Ijasz.reklam());
                    System.out.println(Griff.reklam());
                    System.out.println(Sarkany.reklam());
                    System.out.println(VampirUr.reklam());
                    System.out.println("semmilyet (0)\nMelyik egysegbol akarsz vasarolni?");
                    System.out.println("Jelenlegi penzed: "+jatekos.getArany());
                    System.out.println("A sereged egyszegei: "+jatekos.getSereg());
                    String boltValaszt2 = nehezegScan.nextLine();
                    String mennyiseg;
                    switch (boltValaszt2.toLowerCase()) {
                        case "foldmuves":
                            System.out.println("Add meg a kivant mennyiseget");
                            mennyiseg = nehezegScan.nextLine();
                            boolean isnumber;
                            try {
                                Integer.parseInt(mennyiseg);
                                isnumber =  true;
                            } catch(NumberFormatException e){isnumber = false;}
                            if(!isnumber){
                                System.err.println("Nem egesz szamot adtal meg!");
                                break;
                            }
                            if (Integer.parseInt(mennyiseg) * janos.getAr() > jatekos.getArany()) {
                                System.err.println("Le vagy egve ehez az uzlethez komam!");
                            } else {
                                jatekos.setArany(jatekos.getArany() - Integer.parseInt(mennyiseg) * janos.getAr());
                                if (jatekos.getSereg().contains(janos)) {
                                    int index = jatekos.getSereg().indexOf(janos);
                                    janos.setLetszam(janos.getLetszam() + Integer.parseInt(mennyiseg));
                                    jatekos.getSereg().set(index, janos);
                                    }else{
                                        janos.setLetszam(janos.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().add(janos);
                                    }
                                }
                            break;
                            case "ijasz":
                                System.out.println("Add meg a kivant mennyiseget");
                                mennyiseg = nehezegScan.nextLine();
                                try {
                                    Integer.parseInt(mennyiseg);
                                isnumber =  true;}
                                catch(NumberFormatException e){isnumber = false;}
                                if(!isnumber){
                                    System.err.println("Nem egesz szamot adtal meg!");
                                    break;
                                }
                                if (Integer.parseInt(mennyiseg) * Robin.getAr() > jatekos.getArany()){
                                    System.err.println("Le vagy egve ehez az uzlethez komam!");
                                }else{
                                    jatekos.setArany(jatekos.getArany() - Integer.parseInt(mennyiseg) * Robin.getAr());
                                    if (jatekos.getSereg().contains(Robin)) {
                                        int index = jatekos.getSereg().indexOf(Robin);
                                        Robin.setLetszam(Robin.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().set(index, Robin);
                                    }else{
                                        Robin.setLetszam(Robin.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().add(Robin);
                                    }
                                }
                                break;
                            case "griff":
                                System.out.println("Add meg a kivant mennyiseget");
                                mennyiseg = nehezegScan.nextLine(); try {
                                Integer.parseInt(mennyiseg);
                                isnumber =  true;
                            } catch(NumberFormatException e){isnumber = false;}
                                if(!isnumber){
                                    System.err.println("Nem egesz szamot adtal meg!");
                                    break;
                                }
                                if (Integer.parseInt(mennyiseg) * elfuseraltSas.getAr() > jatekos.getArany()) {
                                    System.err.println("Le vagy egve ehez az uzlethez komam!");
                                } else {
                                    jatekos.setArany(jatekos.getArany() - Integer.parseInt(mennyiseg) * elfuseraltSas.getAr());
                                    if (jatekos.getSereg().contains(elfuseraltSas)
                                    ) {
                                        int index = jatekos.getSereg().indexOf(elfuseraltSas);
                                        elfuseraltSas.setLetszam(elfuseraltSas.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().set(index, elfuseraltSas);
                                    } else {
                                        elfuseraltSas.setLetszam(elfuseraltSas.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().add(elfuseraltSas);
                                    }
                                }
                                break;
                            case "sarkany":
                                System.out.println("Add meg a kivant mennyiseget");
                                mennyiseg = nehezegScan.nextLine(); try {
                                Integer.parseInt(mennyiseg);
                                isnumber =  true;
                            } catch(NumberFormatException e){isnumber = false;}
                                if(!isnumber){
                                    System.err.println("Nem egesz szamot adtal meg!");
                                    break;
                                }
                                if (Integer.parseInt(mennyiseg) * bigGyik.getAr() > jatekos.getArany()) {
                                    System.err.println("Le vagy egve ehez az uzlethez komam!");
                                } else {
                                    jatekos.setArany(jatekos.getArany() - Integer.parseInt(mennyiseg) * bigGyik.getAr());
                                    if (jatekos.getSereg().contains(bigGyik)) {
                                        int index = jatekos.getSereg().indexOf(bigGyik);
                                        bigGyik.setLetszam(bigGyik.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().set(index, bigGyik);
                                    } else {
                                        bigGyik.setLetszam(bigGyik.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().add(bigGyik);
                                    }

                                }
                                break;
                            case "vampirur" :
                                System.out.println("Add meg a kivant mennyiseget");
                                mennyiseg = nehezegScan.nextLine(); try {
                                Integer.parseInt(mennyiseg);
                                isnumber =  true;
                            } catch(NumberFormatException e){isnumber = false;}
                                if(!isnumber){
                                    System.err.println("Nem egesz szamot adtal meg!");
                                    break;
                                }
                                if (Integer.parseInt(mennyiseg) * verszittya.getAr() > jatekos.getArany()) {
                                    System.err.println("Le vagy egve ehez az uzlethez komam!");
                                } else {
                                    jatekos.setArany(jatekos.getArany() - Integer.parseInt(mennyiseg) * verszittya.getAr());
                                    if (jatekos.getSereg().contains(verszittya)) {
                                        int index = jatekos.getSereg().indexOf(verszittya);
                                        verszittya.setLetszam(verszittya.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().set(index, verszittya);
                                    } else {
                                        verszittya.setLetszam(verszittya.getLetszam() + Integer.parseInt(mennyiseg));
                                        jatekos.getSereg().add(verszittya);
                                    }}
                                break;
                            default:
                                System.out.println("Nem valasztottal egyik egysegbol sem");
                                break;
                        }

                    if (jatekos.getSereg().size() == 0) {
                        System.err.println("Sereg nelkul nem vonulhatsz csataba!");
                        continue;
                    }
                    if (boltValaszt2.equalsIgnoreCase("0")) {
                        break;
                    }}

                while (true) {
                    System.out.println("Milyen magiakat szeretnel tanulni" +
                            "\nvillam: " + villam.getAr() + " aranyert " + villam.getManna() + "mana/hasznalat" +
                            "\ntuzlabda: " + tuzlabda.getAr() + " aranyert " + tuzlabda.getManna() + "mana/hasznalat" +
                            "\nbanat: " + banat.getAr() + " aranyert " + banat.getManna() + "mana/hasznalat" +
                            ", Lejebb viszi az enemy egysegeinek kezdemenyezeset"+
                            "\nsiettseg: " + siettseg.getAr() + " aranyert " + siettseg.getManna() + "mana/hasznalat" +
                            ", Feljebb viszi az egysegeid sebesseget"+
                            "\nfeltamasztas: " + felelesztes.getAr() + " aranyert " + felelesztes.getManna() + "mana/hasznalat"
                            + "\nsemmilyet (0)");
                    System.out.println("Jelenlegi penzed: "+jatekos.getArany());
                    System.out.println("Jelenlegi varazskonyved tartalma: "+jatekos.getVarazskonyv());
                    String varazsvalaszt = nehezegScan.nextLine();
                    if (varazsvalaszt.equalsIgnoreCase("villam")) {
                        if (jatekos.getArany() < villam.getAr()) {
                            System.out.println("nincs eleg penzed erre a varazslatra!!");
                        }
                        if(!jatekos.getVarazskonyv().contains(villam)){
                            jatekos.getVarazskonyv().add(villam);
                            jatekos.setArany(jatekos.getArany() - villam.getAr());
                        } else{
                        System.out.println("Mar rendelkezel ezzel a varazslattal!!");
                    }}
                    if (varazsvalaszt.equalsIgnoreCase("tuzlabda")) {
                        if (jatekos.getArany() < tuzlabda.getAr()) {
                            System.out.println("nincs eleg penzed erre a varazslatra!!");
                        }
                        if(!jatekos.getVarazskonyv().contains(tuzlabda)){
                            jatekos.getVarazskonyv().add(tuzlabda);
                        jatekos.setArany(jatekos.getArany() - tuzlabda.getAr());
                    } else{
                        System.out.println("Mar rendelkezel ezzel a varazslattal!!");
                    }}
                    if (varazsvalaszt.equalsIgnoreCase("feltamasztas")) {
                        if (jatekos.getArany() < felelesztes.getAr()) {
                            System.out.println("nincs eleg penzed erre a varazslatra!!");
                        }
                        if(!jatekos.getVarazskonyv().contains(felelesztes)){
                            jatekos.getVarazskonyv().add(felelesztes);
                        jatekos.setArany(jatekos.getArany() - felelesztes.getAr());
                    } else{
                        System.out.println("Mar rendelkezel ezzel a varazslattal!!");
                    }}
                    if (varazsvalaszt.equalsIgnoreCase("banat")) {
                        if (jatekos.getArany() < banat.getAr()) {
                            System.out.println("nincs eleg penzed erre a varazslatra!!");
                        }
                        if(!jatekos.getVarazskonyv().contains(banat)){
                            jatekos.getVarazskonyv().add(banat);
                            jatekos.setArany(jatekos.getArany() - banat.getAr());
                        } else{
                            System.out.println("Mar rendelkezel ezzel a varazslattal!!");
                        }}
                    if (varazsvalaszt.equalsIgnoreCase("siettseg")) {
                        if (jatekos.getArany() < siettseg.getAr()) {
                            System.out.println("nincs eleg penzed erre a varazslatra!!");
                        }
                        if(!jatekos.getVarazskonyv().contains(siettseg)){
                            jatekos.getVarazskonyv().add(siettseg);
                            jatekos.setArany(jatekos.getArany() - siettseg.getAr());
                        } else{
                            System.out.println("Mar rendelkezel ezzel a varazslattal!!");
                        }}
                    if (varazsvalaszt.equalsIgnoreCase("0")) {
                        break;
                    }


                    System.out.println("Szeretned befejezni a shoppingolast?");
                    String boltValaszt = nehezegScan.nextLine();
                    if (boltValaszt.toLowerCase().equals("y")){
                        break;
                    }

                }





        System.out.println(jatekos.getSereg());

        jatekos.setMana(jatekos.getTudas()*10);
        igaziMestersegesIntelligencia.setMana(igaziMestersegesIntelligencia.getTudas()*10);
        for (int i = 0; i < jatekos.getSereg().size(); i++) {
            Egyseg letevendo = jatekos.getSereg().get(i);
            System.out.println(csatater);
            System.out.println("Helyezd el a "+letevendo+" egyseget! Csak az elso ket oszlopra helyezhetsz (x,y)");
            String EgysegPosition = nehezegScan.nextLine();
            String[] trimmEltEgysegPosition = EgysegPosition.strip().split(",");
            try {
                Integer.parseInt(trimmEltEgysegPosition[0]);
                Integer.parseInt(trimmEltEgysegPosition[1]);
            } catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.err.println("Nem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");i--;continue;}
            int iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
            int ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
            if(ipszilon>1){
                System.err.println("nem helyezhetsz ilyen messzire egyseget!");
                i--;
                continue;
            }
            if(iksz>9 || iksz<0){
                System.err.println("Mapon kivulre helyezni eleg nagy cheat lenne");
                i--;continue;}
            if(ipszilon>11 || ipszilon<0){
                System.err.println("Mapon kivulre helyezni eleg nagy cheat lenne");
                i--;continue;}
            if(csatater.mezok[iksz][ipszilon] == null){
                letevendo.setKoordinata(EgysegPosition);
                csatater.mezok[iksz][ipszilon] = letevendo;}
            else {
                System.err.println("Ide mar raktal egyseget "+csatater.mezok[iksz][ipszilon]);
                i--;
            }
        }
        jatekos.setMoral(10);
        jatekos.setTudlepni(true);
        LinkedList<Egyseg> turnSorrend = new LinkedList<>();
        turnSorrend.addAll(jatekos.getSereg());
        turnSorrend.addAll(igaziMestersegesIntelligencia.getSereg());
        for (int i = 0; i < turnSorrend.size() ; i++) {
            if(jatekos.getSereg().contains(turnSorrend.get(i))) {
                turnSorrend.get(i).setKezdemenyezes(turnSorrend.get(i).getKezdemenyezes() + jatekos.getMoral());
                turnSorrend.get(i).setVisszaTamad(true);
                turnSorrend.get(i).setNev(turnSorrend.get(i).getNev()+"(P)");
            }
            else{
                turnSorrend.get(i).setKezdemenyezes(turnSorrend.get(i).getKezdemenyezes()+igaziMestersegesIntelligencia.getMoral());
                turnSorrend.get(i).setVisszaTamad(true);
                turnSorrend.get(i).setNev(turnSorrend.get(i).getNev()+"(CPU)");
            }
        }
        csatater.mezok[2][11] = jozsef;
        jozsef.setKoordinata("2,11");
        csatater.mezok[5][11] = telVilmos;
        telVilmos.setKoordinata("5,11");
        csatater.mezok[8][11] = torzGalamb1;
        torzGalamb1.setKoordinata("8,11");
        System.out.println("Az ellenfeled hose:" +
                "\nTamadas ("+igaziMestersegesIntelligencia.getTamadas()+")\t" +
                "Vedekezes ("+igaziMestersegesIntelligencia.getVedekezes()+")\t" +
                "Varazsero ("+igaziMestersegesIntelligencia.getVarazsero()+")\t" +
                "Tudas ("+igaziMestersegesIntelligencia.getTudas()+")\t" +
                "Moral ("+igaziMestersegesIntelligencia.getMoral()+")\t" +
                "Szerencse ("+igaziMestersegesIntelligencia.getSzerencse()+")\t");

          // kor eleje

        int korszam = 0;
        while(jatekos.getSereg().size()!=0&&igaziMestersegesIntelligencia.getSereg().size()!=0){
            korszam+=1;
            for (int i = 0; i < turnSorrend.size() ; i++) {
                if(jatekos.getSereg().contains(turnSorrend.get(i))) {
                    turnSorrend.get(i).setVisszaTamad(true);
                }
                else{
                    turnSorrend.get(i).setVisszaTamad(true);
                }
            }
            jatekos.setTudlepni(true);
            turnSorrend.sort(Egyseg::compareTo);
            int iksz = 0;
            int ipszilon = 0;
            int piksz = 0;
            int pipszilon = 0;

            for (int i = 0; i < turnSorrend.size() ; i++) {
                for (int j = 0; j < turnSorrend.size() ; j++){
                    if(turnSorrend.get(j).isHalott()) {
                        String[] EgysegPosition = turnSorrend.get(j).getKoordinata().split(",");
                        iksz = Integer.parseInt(EgysegPosition[0]);
                        ipszilon = Integer.parseInt(EgysegPosition[1]);
                        csatater.mezok[iksz][ipszilon] = null;
                        jatekos.getSereg().remove(turnSorrend.get(j));
                        igaziMestersegesIntelligencia.getSereg().remove(turnSorrend.get(j));
                        turnSorrend.remove(turnSorrend.get(j));

                    }}
                if (igaziMestersegesIntelligencia.getSereg().contains(turnSorrend.get(i))) {
                    String pos = turnSorrend.get(i).getKoordinata();
                    String[] trimmEltEgysegPosition = pos.strip().split(",");
                    iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
                    ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
                    if (iksz + 1 < 10 && ipszilon < 12 && iksz + 1 > 0 && ipszilon > 0) {
                        if (jatekos.getSereg().contains(csatater.mezok[iksz + 1][ipszilon])) {
                            turnSorrend.get(i).csatazik(igaziMestersegesIntelligencia, jatekos, csatater.mezok[iksz + 1][ipszilon], csatater);
                           // continue;
                        }
                    }
                    else if (iksz - 1 < 10 && ipszilon < 12 && iksz - 1 > 0 && ipszilon > 0) {
                        if (jatekos.getSereg().contains(csatater.mezok[iksz - 1][ipszilon])) {
                            turnSorrend.get(i).csatazik(igaziMestersegesIntelligencia, jatekos, csatater.mezok[iksz - 1][ipszilon], csatater);
                            //continue;
                        }
                    }
                    else if (iksz < 10 && ipszilon + 1 < 12 && iksz > 0 && ipszilon + 1 > 0) {
                        if (jatekos.getSereg().contains(csatater.mezok[iksz][ipszilon + 1])) {
                            turnSorrend.get(i).csatazik(igaziMestersegesIntelligencia, jatekos, csatater.mezok[iksz][ipszilon + 1], csatater);
                            //continue;
                        }
                    }
                    else if (iksz < 10 && ipszilon - 1 < 12 && iksz > 0 && ipszilon - 1 > 0) {
                        if (jatekos.getSereg().contains(csatater.mezok[iksz][ipszilon - 1])) {
                            turnSorrend.get(i).csatazik(igaziMestersegesIntelligencia, jatekos, csatater.mezok[iksz][ipszilon - 1], csatater);
                            //continue;
                        }
                    }
                    piksz = (int) (Math.random() * 9);
                    pipszilon = (int) (Math.random() * 11);
                    if (!turnSorrend.get(i).mozgas(piksz, pipszilon, csatater)) {
                        i--;
                    }
                }
                else if(jatekos.getSereg().contains(turnSorrend.get(i))) {
                    System.out.println(csatater);
                    System.out.println(korszam + ". kor");
                    System.out.println("Egysegek sorrendje: " + turnSorrend);
                    System.out.println("Aktualisan soron levo egyseg: " + turnSorrend.get(i));
                    System.out.println(jatekos.getMana() + " manad van");
                    System.out.println("Mit akarsz csinalni? \nVarakozni(0)  Mozogni(1)  Tamadni(2) Hos(3) feladni(4)");
                    String choice = nehezegScan.nextLine();
                    if (Objects.equals(choice, "0")) {
                        continue;
                    } else if (choice.equals("1")) {
                        System.out.println("Hova akarsz lepni a " + turnSorrend.get(i) + " vel?");
                        String kor = nehezegScan.nextLine();
                        String[] trimmEltEgysegPosition = kor.strip().split(",");
                        try {
                            Integer.parseInt(trimmEltEgysegPosition[0]);
                            Integer.parseInt(trimmEltEgysegPosition[1]);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.err.println("Nem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");
                            i--;
                            continue;
                        }
                        iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
                        ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
                        if (!turnSorrend.get(i).mozgas(iksz, ipszilon, csatater)) {
                            i--;
                        }
                    } else if (choice.equals("2")) {
                        String[] trimmEltEgysegPosition = turnSorrend.get(i).getKoordinata().strip().split(",");
                        try {
                            Integer.parseInt(trimmEltEgysegPosition[0]);
                            Integer.parseInt(trimmEltEgysegPosition[1]);
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.err.println("NNem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");
                            i--;
                            continue;
                        }
                        iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
                        ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
                        Egyseg bal = null;
                        Egyseg jobb = null;
                        Egyseg lent = null;
                        Egyseg fent = null;
                        if (iksz + 1 < csatater.mezok.length) {
                            lent = csatater.mezok[iksz + 1][ipszilon];
                        }
                        if (iksz - 1 > 0) {
                            fent = csatater.mezok[iksz - 1][ipszilon];
                        }
                        if (ipszilon + 1 < csatater.mezok[0].length) {
                            jobb = csatater.mezok[iksz][ipszilon + 1];
                        }
                        if (ipszilon - 1 > 0) {
                            bal = csatater.mezok[iksz][ipszilon - 1];
                        }
                        if (bal != null || jobb != null || fent != null || lent != null) {
                            System.out.println("Kit akarsz megtamadni? (fent,lent,bal,jobb)");
                            String szomszed = nehezegScan.nextLine();
                            if (szomszed.equals("fent") && fent != null) {
                                turnSorrend.get(i).csatazik(jatekos, igaziMestersegesIntelligencia, fent, csatater);
                            } else if (szomszed.equals("fent")) {
                                System.err.println("nincs fent egyseg akit tamadhatnal! ");
                                i--;
                                continue;
                            }
                            if (szomszed.equals("lent") && lent != null) {
                                turnSorrend.get(i).csatazik(jatekos, igaziMestersegesIntelligencia, lent, csatater);
                            } else if (szomszed.equals("lent")) {
                                System.err.println("nincs lent egyseg akit tamadhatnal! ");
                                i--;
                                continue;
                            }
                            if (szomszed.equals("bal") && bal != null) {
                                turnSorrend.get(i).csatazik(jatekos, igaziMestersegesIntelligencia, bal, csatater);
                            } else if (szomszed.equals("bal")) {
                                System.err.println("nincs bal egyseg akit tamadhatnal! ");
                                i--;
                                continue;
                            }
                            if (szomszed.equals("jobb") & jobb != null) {
                                turnSorrend.get(i).csatazik(jatekos, igaziMestersegesIntelligencia, jobb, csatater);
                            } else if (szomszed.equals("jobb")) {
                                System.err.println("nincs jobb egyseg akit tamadhatnal! ");
                                i--;
                            }
                        } else {
                            System.err.println("nincs szomszedos egyseg akit tamadhatnal! ");
                            i--;
                        }
                    } else if (choice.equals("4")) {
                        System.out.println("Megfutamodtal!");
                        return;
                    } else if (choice.equals("3") && jatekos.isTudlepni()) {
                        System.out.println("Varazsolni (1) vagy tamadni akarsz (2)?");
                        String varazsTamad = nehezegScan.nextLine();
                        if (varazsTamad.equalsIgnoreCase("1")) {
                            System.out.println("Melyik varazslatodat kivanod hasznalni? (villam,tuzlabda etc)");
                            System.out.println(jatekos.getVarazskonyv());
                            String varazsvalaszt = nehezegScan.nextLine();
                            if (varazsvalaszt.equalsIgnoreCase("villam") && jatekos.getVarazskonyv().contains(villam)) {
                                if (villam.getManna() <= jatekos.getMana()) {
                                    if (villam.effekt(jatekos, csatater)) {
                                        jatekos.setMana(jatekos.getMana() - villam.getManna());
                                        i--;
                                    } else {
                                        i--;
                                    }
                                } else {
                                    System.err.println("nincs eleg manad!");
                                    i--;
                                }
                            } else if (varazsvalaszt.equalsIgnoreCase("banat") && jatekos.getVarazskonyv().contains(banat)) {
                                if (banat.getManna() <= jatekos.getMana()) {
                                    banat.Baneffekt(jatekos, igaziMestersegesIntelligencia, csatater);
                                    jatekos.setMana(jatekos.getMana() - banat.getManna());
                                    i--;
                                } else {
                                    System.err.println("nincs eleg manad!");
                                    i--;
                                }
                            } else if (varazsvalaszt.equalsIgnoreCase("siettseg") && jatekos.getVarazskonyv().contains(siettseg)) {
                                if (siettseg.getManna() <= jatekos.getMana()) {
                                    siettseg.effekt(jatekos, csatater);
                                    jatekos.setMana(jatekos.getMana() - siettseg.getManna());
                                    i--;
                                } else {
                                    System.err.println("nincs eleg manad!");
                                    i--;
                                }
                            } else if (varazsvalaszt.equalsIgnoreCase("tuzlabda") && jatekos.getVarazskonyv().contains(tuzlabda)) {
                                if (tuzlabda.getManna() <= jatekos.getMana()) {
                                    tuzlabda.effekt(jatekos, csatater);
                                    jatekos.setMana(jatekos.getMana() - tuzlabda.getManna());
                                    i--;
                                } else {
                                    System.err.println("nincs eleg manad!");
                                    i--;
                                }
                            } else {
                                System.err.println("Nincs ilyen varazslat a birtokodban!");
                                i--;
                            }


                        } else if (varazsTamad.equalsIgnoreCase("2")) {
                            System.out.println("melyik pozicioban levo ellenfelet akarod megtamadni? (x,y)");
                            String pos = nehezegScan.nextLine();
                            String[] trimmEltEgysegPosition = pos.strip().split(",");
                            try {
                                Integer.parseInt(trimmEltEgysegPosition[0]);
                                Integer.parseInt(trimmEltEgysegPosition[1]);
                            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                                System.err.println("Nem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");
                                i--;
                                continue;
                            }
                            iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
                            ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
                            if (csatater.mezok[iksz][ipszilon] != null && !jatekos.getSereg().contains(csatater.mezok[iksz][ipszilon])) {
                                csatater.mezok[iksz][ipszilon].setLetszam(
                                        csatater.mezok[iksz][ipszilon].getLetszam() - jatekos.getTamadas() * 10

                                );
                                jatekos.setTudlepni(false);
                            }else{
                                i--;
                                System.err.println("Nincs itt ellenseges egyseg!");
                            }
                            i--;
                        }
                    } else if (choice.equals("3") && !jatekos.isTudlepni()) {
                        System.err.println("mar leptel ebben a korben a hosoddel!");
                        i--;
                    } else  {
                        System.err.println("rossz input");
                        i--;
                    }
                }
                for (int j = 0; j < turnSorrend.size() ; j++){
                    if(turnSorrend.get(j).isHalott()) {
                        String[] EgysegPosition = turnSorrend.get(j).getKoordinata().split(",");
                        iksz = Integer.parseInt(EgysegPosition[0]);
                        ipszilon = Integer.parseInt(EgysegPosition[1]);
                        csatater.mezok[iksz][ipszilon] = null;
                        jatekos.getSereg().remove(turnSorrend.get(j));
                        igaziMestersegesIntelligencia.getSereg().remove(turnSorrend.get(j));
                        turnSorrend.remove(turnSorrend.get(j));

                    }}
            }
        }

        if(jatekos.getSereg().size()!=0){
            System.out.println("Gratulalok a gyozelemhez!");
        }else{
            System.out.println("Hadsereged megsemmisito vereseget szenvedett");
        }

    }
}

