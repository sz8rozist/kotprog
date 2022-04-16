package Game;

import Egysegek.*;
import Hos.Hos;
import Palya.Palya;
import Varazslatok.*;
import Colors.*;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String args[]){
        int nehezseg = 0;
        Hos hos = new Hos();
        Palya p = new Palya();
        Hos ellenfel = hos.createEllenfel();
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        Feltamasztas feltamasztas = new Feltamasztas();
        Tuzlabda tuzlabda = new Tuzlabda();
        Villamcsapas villamcsapas = new Villamcsapas();
        Tornado tornado = new Tornado();
        Nyilzapor nyilzapor = new Nyilzapor();

        Foldmuves foldmuves = new Foldmuves();
        Griff griff = new Griff();
        Ijasz ijasz = new Ijasz();

      //chooseLevel(nehezseg, hos, sc);
     // choosHosTulajdonsag(hos,sc);
     chooseVarazslatok(hos, sc, feltamasztas, tuzlabda, villamcsapas, tornado,nyilzapor);
      chooseSereg(hos,sc, foldmuves, griff, ijasz);
      ellenfelBeallitas(feltamasztas, tuzlabda, villamcsapas, tornado, nyilzapor, foldmuves, griff, ijasz, ellenfel, rnd);
      egysegElhelyezese(p, hos,sc, ellenfel, rnd);
      ellenfel.ellenfelAdatai();
      jatek(hos, ellenfel, p, sc);
    }
    public static void chooseLevel(int nehezseg, Hos hos, Scanner sc){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Válaszd ki a nehézségi szintet! ----------------------------->"+Colors.ANSI_RESET);
        System.out.println("1 - Könnyű");
        System.out.println("2 - Közepes");
        System.out.println("3 - Nehéz");
        System.out.println(Colors.ANSI_BLUE +"<------------------------------------------------------------------------------------------->"+ Colors.ANSI_RESET);
        System.out.print("Kérlek add meg a nehézségi szint sorszámát: ");
        nehezseg = sc.nextInt();
        hos.setArany(nehezseg);
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Válaszd ki a hősöd tulajdonságpontjait! ----------------------------->"+Colors.ANSI_RESET);
    }
    public static void choosHosTulajdonsag(Hos hos, Scanner sc){
        int in;
        do{
            System.out.println("Tulajdonságpontok");
            System.out.println("1 - Támadás: "+ hos.getTamadas() + " ára: "+ (int)hos.getAr());
            System.out.println("2 - Védekezés: " + hos.getVedekezes() + " ára: "+ (int)hos.getAr());
            System.out.println("3 - Varázserő: " + hos.getVarazsero()  + " ára: "+ (int)hos.getAr());
            System.out.println("4 - Tudás: " + hos.getTudas()  + " ára: "+ (int)hos.getAr());
            System.out.println("5 - Morál: " + hos.getMoral()  + " ára: "+ (int)hos.getAr());
            System.out.println("6 - Szerencse: " + hos.getSzerencse()  + " ára: "+ (int)hos.getAr());
            System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
            System.out.println("10 - Tovább a varázslatok megvásárlásához!");
            in = sc.nextInt();
            hos.setTulajdonsagpontok(in);
        }while(in != 10);
    }
    public static void chooseVarazslatok(Hos hos, Scanner sc, Feltamasztas feltamasztas,Tuzlabda tuzlabda, Villamcsapas villamcsapas, Tornado tornado, Nyilzapor nyilzapor){

        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Vásárolj varázslatokat! ----------------------------->"+Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);

        int darab;
        int darab2;
        do{
            System.out.println("Varázslatok");
            System.out.println("1 - Feltámasztás (ára: " + feltamasztas.getAr() + ") (manaköltsége: "+ feltamasztas.getMana()+ "):");
            System.out.println("2 - Tűzlabda (ára: " + tuzlabda.getAr() + ") (manaköltsége: "+ tuzlabda.getMana()+ "):");
            System.out.println("3 - Villámcsapás (ára: " + villamcsapas.getAr() + ") (manaköltsége: "+ villamcsapas.getMana()+ "):");
            System.out.println("4 - Tornádó (ára: " + tornado.getAr() + ") (manaköltsége: "+ tornado.getMana()+ "):");
            System.out.println("5 - Nyílzápor (ára: " + nyilzapor.getAr() + ") (manaköltsége: "+ nyilzapor.getMana()+ "):");
            System.out.println("10 - Tovább a sereg összeállításához!");
            System.out.print("Melyik varázslatot szeretnéd?: ");
            darab = sc.nextInt();

            switch (darab) {
                case 1 -> {
                    System.out.print("Hány darabot veszel?:");
                    darab2 = sc.nextInt();
                    if(!hos.vanelegArany(feltamasztas.getAr() * darab2)){
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                    feltamasztas.vasarol(hos,darab2, hos.getVarazslat());

                }
                case 2 -> {
                    System.out.print("Hány darabot veszel?:");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tuzlabda.getAr()  * darab2)){
                        tuzlabda.vasarol(hos,darab2, hos.getVarazslat());
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 3 -> {
                    System.out.print("Hány darabot veszel?:");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(villamcsapas.getAr() * darab2)){
                        villamcsapas.vasarol(hos,darab2, hos.getVarazslat());
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 4 -> {
                    System.out.print("Hány darabot veszel?:");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tornado.getAr() * darab2)){
                        tornado.vasarol(hos,darab2, hos.getVarazslat());
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 5 -> {
                    System.out.print("Hány darabot veszel?:");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(nyilzapor.getAr() * darab2)){
                        nyilzapor.vasarol(hos,darab2, hos.getVarazslat());
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
            }
        }while(darab != 10);
    }
    public static void chooseSereg(Hos hos, Scanner sc, Foldmuves foldmuves, Griff griff, Ijasz ijasz){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Állítsd össze a sereged! ----------------------------->"+Colors.ANSI_RESET);
        int d;
        int db;
        while(!hos.vanKivalasztvaSereg()){
            do{
                System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
                System.out.println("1 - "+foldmuves.getNev());
                System.out.println("2 - "+griff.getNev());
                System.out.println("3 - "+ijasz.getNev());
                System.out.println("10 - Kezdődjön a csata!");
                System.out.print("Melyik egységet szeretnéd?: ");
                d = sc.nextInt();
                switch (d) {
                    case 1 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(foldmuves.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        foldmuves.egysegVasarlas(hos,db, hos.getEgyseg());
                    }
                    case 2 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(griff.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        griff.egysegVasarlas(hos,db, hos.getEgyseg());
                    }
                    case 3 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(ijasz.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        ijasz.egysegVasarlas(hos,db, hos.getEgyseg());
                    }

                }
            }while(d != 10);
        }
    }
    public static void egysegElhelyezese(Palya p, Hos hos, Scanner sc, Hos ellenfel, Random rnd){
        String oszlop = "";
        int sor = 0;
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Helyezd el az egységeidet a pályán! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        for(Egyseg egyseg : ellenfel.getEllenfelEgyseg()){
            if(egyseg != null){
                int sorr = rnd.nextInt((10 - 1) + 1) + 1;
                char c = rnd.nextBoolean() ? 'H' : 'I';
                p.ellenfelEgysegeinekElhelyezese(egyseg, String.valueOf(c),sorr);
            }
        }
        System.out.println("Helyezd el a pályán az egységeidet!");
        for(Egyseg e : hos.getEgyseg()){
            if(e != null){
                do{
                    System.out.println("Hova tegyük a "+ e.getNev() + " egységet?");
                    System.out.print("Oszlop: ");
                    oszlop = sc.next();
                    System.out.print("Sor: ");
                    sor = sc.nextInt();
                }while(!p.egysegElhelyezes(e, oszlop,sor));
            }
        }
        p.printPalya();
    }
    public static void ellenfelBeallitas(Feltamasztas feltamasztas, Tuzlabda tuzlabda, Villamcsapas villamcsapas,Tornado tornado, Nyilzapor nyilzapor, Foldmuves foldmuves, Griff griff, Ijasz ijasz, Hos ellenfel, Random rnd){
        feltamasztas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1, ellenfel.getEllenfelVarazslat());
        tuzlabda.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1, ellenfel.getEllenfelVarazslat());
        villamcsapas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1, ellenfel.getEllenfelVarazslat());
        tornado.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1, ellenfel.getEllenfelVarazslat());
        nyilzapor.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1, ellenfel.getEllenfelVarazslat());

        foldmuves.egysegVasarlas(ellenfel, rnd.nextInt((6 - 1) + 1) + 1, ellenfel.getEllenfelEgyseg());
        griff.egysegVasarlas(ellenfel, rnd.nextInt((6 - 1) + 1) + 1, ellenfel.getEllenfelEgyseg());
        ijasz.egysegVasarlas(ellenfel, rnd.nextInt((6 - 1) + 1) + 1, ellenfel.getEllenfelEgyseg());
    }
    public static void jatek(Hos hos, Hos ellenfel, Palya p, Scanner sc){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Kezdődjön a játék! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        String karakter;
        int szam = 0;
        int hanyEgyseg = 0;
        int merre = 0;
        int h = 0;
        int kivalasztottVarazslat = 0;
        int megtamadottEgyseg = 0;
        System.out.print(Colors.ANSI_GREEN + "Egységgel szeretnél lépni vagy a hősöddel? (e/h) "+ Colors.ANSI_RESET);
        karakter = sc.next();
        switch (karakter){
            case "e":
                System.out.println("1 - Mozgás");
                System.out.println("2 - Várakozás");
                System.out.println("3 - Támadás");
                System.out.print("Mit szeretnél tenni az egységgel?: ");
                szam = sc.nextInt();
                switch (szam){
                    case 1:
                        System.out.print("Merre mozogjon? (1 - előre, 2 - hátra, 3 - jobbra, 4 - balra)");
                        merre = sc.nextInt();
                        System.out.print("Hány egységet mozogjon?: ");
                        hanyEgyseg = sc.nextInt();
                        p.mozgas(hos.getEgyseg(), hanyEgyseg, merre);
                        break;
                    case 2:  break;
                    case 3: break;
                }
            case "h":
                System.out.print("1 - Támadás / 2 - Varázslás: ");
                h = sc.nextInt();
                if(h == 1){
                    int c = 0;
                    System.out.println("Az ellenfél egységei: ");
                    for(Egyseg e : ellenfel.getEllenfelEgyseg()){
                        if(e != null){
                            c++;
                            System.out.println(c+" - "+e.getNev()+ "eletero: "+ e.getEletero());
                        }
                    }
                    System.out.print("Melyik egységet támadjuk: ");
                    megtamadottEgyseg = sc.nextInt();
                    hos.hosTamad(megtamadottEgyseg, ellenfel.getEllenfelEgyseg());
                }else if(h == 2){
                    System.out.println("Felhasználható varázslatok");
                    int counter = 0;
                    int c = 0;
                    for(Varazslat v : hos.getVarazslat()){
                        if(v != null){
                            counter++;
                            System.out.println(counter +" - "+v.getNev()+" / mana: "+ v.getMana());
                        }
                    }
                    System.out.print("Melyik varázslatot választod?: ");
                    kivalasztottVarazslat = sc.nextInt();
                    Varazslat kivalasztott = hos.kivalasztottVarazslat(kivalasztottVarazslat);
                    if(kivalasztott.getNev().equals("Villámcsapás")){
                        System.out.println("Ellenfél egységei: ");
                        for(Egyseg e : ellenfel.getEllenfelEgyseg()){
                            if(e != null){
                                c++;
                                System.out.println(c+" - "+e.getNev()+ " eletero: "+ e.getEletero());
                            }
                        }
                        System.out.print("Melyik egységre használnod a varázslást?: ");
                        megtamadottEgyseg = sc.nextInt();
                        kivalasztott.villamcsapas(hos, ellenfel.getEllenfelEgyseg(), megtamadottEgyseg);
                    }
                    if(kivalasztott.getNev().equals("Nyílzápor")){
                        kivalasztott.nyilzapor(hos, ellenfel.getEllenfelEgyseg());
                    }
                    if(kivalasztott.getNev().equals("Tornádó")){
                        kivalasztott.tornado(hos, ellenfel.getEllenfelEgyseg());
                        for(Egyseg e : ellenfel.getEllenfelEgyseg()){
                            if(e != null){
                                c++;
                                System.out.println(c+" - "+e.getNev()+ " eletero: "+ e.getEletero());
                            }
                        }
                    }
                    if(kivalasztott.getNev().equals("Feltámasztás")){

                    }
                }
                break;
        }
        //p.printPalya();
    }
}
