package Varazslatok;

import Hos.Hos;

public class Varazslat {
    protected int ar;
    protected int mana;
    protected String nev;
    protected int darab;

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

    public void vasarol(Hos h, int darab){
        if(getDarab() == 0){
            setDarab(darab);
            if(h.vanelegArany(this.getAr() * darab)){
                int arany = h.getArany();
                arany -= this.getDarab() * this.getAr();
                h.setArany2(arany);
            }
        }
    }

    public boolean vanElegMana(int hosMana){
        if(mana > hosMana){
            return false;
        }else{
            return true;
        }
    }

}
