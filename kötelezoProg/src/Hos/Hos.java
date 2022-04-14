package Hos;

import Colors.Colors;
import Egysegek.Egyseg;
import Varazslatok.Feltamasztas;
import Varazslatok.Varazslat;

import java.util.Random;

public class Hos {
    protected int tamadas;
    protected int vedekezes;
    protected int varazsero;
    protected int tudas;
    protected int moral;
    protected int szerencse;
    protected double ar;
    protected int arany = 1000;
    protected int mana;

    public Varazslat[] varazslat = new Varazslat[5];
    public Egyseg[] egyseg = new Egyseg[5];

    public Varazslat[] ellenfelVarazslat = new Varazslat[5];
    public Egyseg[] ellenfelEgyseg = new Egyseg[5];

    public Varazslat[] getEllenfelVarazslat() {
        return ellenfelVarazslat;
    }

    public void setEllenfelVarazslat(Varazslat[] ellenfelVarazslat) {
        this.ellenfelVarazslat = ellenfelVarazslat;
    }

    public Egyseg[] getEllenfelEgyseg() {
        return ellenfelEgyseg;
    }

    public void setEllenfelEgyseg(Egyseg[] ellenfelEgyseg) {
        this.ellenfelEgyseg = ellenfelEgyseg;
    }

    public Varazslat[] getVarazslat() {
        return varazslat;
    }

    public Egyseg[] getEgyseg() {
        return egyseg;
    }

    public Hos createEllenfel(){
        Random rnd = new Random();
        Hos h = new Hos();
        h.setTamadas(rnd.nextInt((10 - 1) + 1) + 1);
        h.setVedekezes(rnd.nextInt((10 - 1) + 1) + 1);
        h.setVarazsero(rnd.nextInt((10 - 1) + 1) + 1);
        h.setSzerencse(rnd.nextInt((10 - 1) + 1) + 1);
        h.setMoral(rnd.nextInt((10 - 1) + 1) + 1);
        h.setTudas(rnd.nextInt((10 - 1) + 1) + 1);
        h.setArany2(rnd.nextInt((1300 - 500) + 500) + 500);
        h.setMana();
        return h;
    }

    public int getArany() {
        return arany;
    }

    public boolean vanelegArany(int ara){
        if(ara < arany){
            return true;
        }else{
            return false;
        }
    }

    public void arNovel(){
        //10 százalék(ar/10)+ar
        int tizSzazalek = (int) Math.ceil(ar - (ar * 0.9));
        ar += tizSzazalek;
        arany -= ar;
    }

    public void setArany(int level) {
        switch (level) {
            case 1 -> this.arany = 700;
            case 2 -> this.arany = 1000;
            case 3 -> this.arany = 1300;
        }
    }

    public void setArany2(int arany){
        this.arany = arany;

    }

    public double getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
            this.tamadas = tamadas;
    }

    public int getMana() {
        return mana;
    }

    public void setMana() {
        this.mana = mana * tudas;
    }

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
            this.vedekezes = vedekezes;
    }

    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
            this.varazsero = varazsero;
    }

    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
            this.tudas = tudas;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
            this.moral = moral;
    }

    public int getSzerencse() {
        return szerencse;
    }
    public void setSzerencse(int szerencse) {
            this.szerencse = szerencse;
    }

    public Hos() {
        this.tamadas = 1;
        this.vedekezes = 1;
        this.varazsero = 1;
        this.tudas = 1;
        this.moral = 1;
        this.szerencse = 1;
        this.ar = 5;
        this.mana = 10;
    }

    public void setTulajdonsagpontok(int number){
        if(vanelegArany((int)getAr())){
            switch (number) {
                case 1 -> {
                    if(getTamadas() < 10){
                        setTamadas(getTamadas() + 1);
                        arNovel();
                    }else{
                        System.err.println("A támadás értéke max 10 lehet!");
                    }
                }
                case 2 -> {
                    if(getVedekezes() < 10){
                        setVedekezes(getVedekezes() + 1);
                        arNovel();
                    }else{
                        System.err.println("A védekezés értéke max 10 lehet!");
                    }
                }
                case 3 -> {
                    if(getVarazsero() < 10){
                        setVarazsero(getVarazsero() + 1);
                        arNovel();
                    }else{
                        System.err.println("A varázserő értéke max 10 lehet!");
                    }
                }
                case 4 -> {
                    if(getTudas() < 10){
                        setTudas(getTudas() + 1);
                        arNovel();
                    }else{
                        System.err.println("A tudás értéke max 10 lehet!");
                    }
                }
                case 5 -> {
                    if(getMoral() < 10){
                        setMoral(getMoral() + 1);
                        arNovel();
                    }else{
                        System.err.println("A morál értéke max 10 lehet!");
                    }
                }
                case 6 -> {
                    if(getSzerencse() < 10){
                        setSzerencse(getSzerencse() + 1);
                        arNovel();
                    }else{
                        System.err.println("A szerencse értéke max 10 lehet!");
                    }
                }
            }
        }else{
            System.err.println("Nincs elég aranyad!");
        }
    }

    public boolean vanKivalasztvaSereg(){
        for(Egyseg e : egyseg){
            if(e != null){
                return true;
            }
        }
        return false;
    }
    public void ellenfelAdatai(){
        System.out.println();
        System.out.println(Colors.ANSI_BLUE + "Az ellenfél adatai"+ Colors.ANSI_RESET);
        System.out.println("Támadás: "+getTamadas());
        System.out.println("Védekezés: "+getVedekezes());
        System.out.println("Varázserő: "+getVarazsero());
        System.out.println("Tudás: "+getTudas());
        System.out.println("Morál: "+getMoral());
        System.out.println("Szerencse: "+getSzerencse());
        System.out.println("Mana: "+getMana());

        System.out.println(Colors.ANSI_BLUE +"Az ellenfél varázserői:"+ Colors.ANSI_RESET);
        for(Varazslat v : ellenfelVarazslat){
            if(v != null){
                System.out.println("Varázslat: " + v.getNev() + " db: "+ v.getDarab());
            }
        }
        System.out.println(Colors.ANSI_BLUE +"Az ellenfél egységei:"+ Colors.ANSI_RESET);
        for(Egyseg v : ellenfelEgyseg){
            if(v != null){
                System.out.println("Egység: " + v.getNev() + " db: "+v.getDarab());
            }
        }
    }

    public void hosTamad(Egyseg ellenfelEgyseg){
        ellenfelEgyseg.setEletero(ellenfelEgyseg.getEletero() - this.getTamadas() * 10);
    }
}
