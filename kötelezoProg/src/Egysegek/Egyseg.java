package Egysegek;

import Hos.Hos;

import java.util.Random;

public class Egyseg {
    private String nev;
    private int darab;
    private int ar;
    private int[] sebzes;
    private int eletero;
    private int sebesseg;
    private int kezdemenyezes;
    private String melyikOldalonAll;
    private String specialisKepesseg;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
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

    public String getMelyikOldalonAll() {
        return melyikOldalonAll;
    }

    public void setMelyikOldalonAll(String melyikOldalonAll) {
        this.melyikOldalonAll = melyikOldalonAll;
    }

    public String getSpecialisKepesseg() {
        return specialisKepesseg;
    }

    public void setSpecialisKepesseg(String specialisKepesseg) {
        this.specialisKepesseg = specialisKepesseg;
    }

    public Egyseg(){

    }

    public Egyseg(String nev, int ar, int[] sebzes, int eletero, int sebesseg, int kezdemenyezes, String melyikOldalonAll, String specialisKepesseg, int darab) {
        this.nev = nev;
        this.ar = ar;
        this.sebzes = sebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
        this.melyikOldalonAll = melyikOldalonAll;
        this.specialisKepesseg = specialisKepesseg;
        this.darab = darab;
    }

    public void egysegVasarlas(Hos h, int darab){
        setDarab(darab);
        setEletero(darab * this.getEletero());
        setKezdemenyezes(h.getMoral() + getKezdemenyezes());
        int[] s = {darab * getSebzes()[0], darab * getSebzes()[1]};
        setSebzes(s);
        if(h.vanelegArany(this.getAr() * darab)){
            int arany = h.getArany();
            arany -= this.getDarab() * this.getAr();
            h.setArany2(arany);
        }
        //System.out.println("Arany: "+ h.getArany());
    }

    public boolean mozgas(int hanyEgyseg, int merre, String[][] palya){
        String firstLetter = String.valueOf(this.getNev().charAt(0)).toLowerCase();
        if(hanyEgyseg > 13){
            return false;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(merre == 1){
                    if(palya[i][j].equals(firstLetter)){
                        if(!palya[i][j + hanyEgyseg].equals(" ")){
                            return false;
                        }
                        if(hanyEgyseg < 1 || hanyEgyseg > this.getSebesseg() || j + hanyEgyseg > 12){
                            return false;
                        }
                        palya[i][j + hanyEgyseg] = firstLetter;
                        palya[i][j] = " ";
                        return true;
                    }
                }else if(merre == 2){
                    if(palya[i][j].equals(firstLetter)){
                        if(!palya[i][j - hanyEgyseg].equals(" ")){
                            return false;
                        }
                        if (hanyEgyseg < 1 || hanyEgyseg > this.getSebesseg() || j - hanyEgyseg < 0){
                            return false;
                        }
                        palya[i][j - hanyEgyseg] = firstLetter;
                        palya[i][j] = " ";
                        return true;
                    }
                }else if(merre == 3){
                    if(palya[i][j].equals(firstLetter)){
                        if(i == 9){
                            return false;
                        }
                        if (hanyEgyseg < 1 || hanyEgyseg > this.getSebesseg() || i + hanyEgyseg > 9){
                            return false;
                        }
                        palya[i + hanyEgyseg][j] = firstLetter;
                        palya[i][j] = " ";
                        return true;
                    }
                }else if(merre == 4){
                    if(palya[i][j].equals(firstLetter)){
                        if(i == 0){
                            return false;
                        }
                        if (hanyEgyseg < 1 || hanyEgyseg > this.getSebesseg() || i - hanyEgyseg < 0){
                            return false;
                        }
                        palya[i - hanyEgyseg][j] = firstLetter;
                        palya[i][j] = " ";
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void ijjaszTamad(String[][] palya, int melyik, Egyseg[] ellenfel) {
        boolean tudTamadni = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(!palya[i+1][j].equals(" ") && !palya[i-1][j].equals(" ") && !palya[i][j+1].equals(" ") && !palya[i][j-1].equals(" ")){
                    tudTamadni = false;
                }
            }
        }
        if(tudTamadni){
            Random rnd = new Random();
            int counter = 0;
            for(Egyseg e : ellenfel){
                if(e != null){
                    counter++;
                    if(counter == melyik){
                        int sebzes = rnd.nextInt((e.getSebzes()[0] - e.getSebzes()[1]) + e.getSebzes()[0]) + e.getSebzes()[0];
                    }
                }
            }
        }
    }
}
