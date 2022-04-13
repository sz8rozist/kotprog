package Egysegek;

import Hos.Hos;

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

    public void egysegVasarlas(Hos h, int darab, Egyseg[] egyseg){
            for(int i = 0; i<egyseg.length; i++){
                if(egyseg[i] == null){
                    setDarab(darab);
                    setEletero(darab * this.getEletero());
                    int[] s = {darab * getSebzes()[0], darab * getSebzes()[1]};
                    setSebzes(s);
                    egyseg[i] = this;
                    if(h.vanelegArany(this.getAr() * darab)){
                        int arany = h.getArany();
                        arany -= this.getDarab() * this.getAr();
                        h.setArany2(arany);
                    }
                    //System.out.println("Arany: "+ h.getArany());
                }
                if(egyseg[i].getNev().equals(this.getNev())){
                    break;
                }
            }
    }
}
