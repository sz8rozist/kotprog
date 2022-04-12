package Varazslatok;

import Hos.Hos;
import Colors.*;

public class Varazslat {
    private int ar;
    private int mana;
    private String nev;
    private int darab;

    public Varazslat(){

    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Varazslat(String nev,int ar, int mana, int db) {
        this.nev = nev;
        this.ar = ar;
        this.mana = mana;
        this.darab = db;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public void vasarol(Hos h, int darab, Varazslat[] varazs){
        for(int i = 0; i<varazs.length; i++){
                if(varazs[i] == null){
                    setDarab(darab);
                    varazs[i] = this;
                    if(h.vanelegArany(this.getAr() * darab)){
                        int arany = h.getArany();
                        arany -= this.getDarab() * this.getAr();
                        h.setArany2(arany);
                    }
                    System.out.println(Colors.ANSI_YELLOW + "Arany: "+ h.getArany() + Colors.ANSI_RESET);
                }
                if(varazs[i].getNev().equals(this.getNev())){
                    break;
                }
            }
    }
}
