package Game;

import Egysegek.*;
import Hos.Hos;
import Palya.Palya;
import Varazslatok.*;
import Colors.*;
import java.util.Scanner;

public class Game {
    public static void main(String args[]){
        int nehezseg = 0;
        Hos hos = new Hos();
        Palya p = new Palya();
        Hos ellenfel = hos.createEllenfel();
        Scanner sc = new Scanner(System.in);

        System.out.println(ellenfel.toString());

      chooseLevel(nehezseg, hos, sc);
      choosHosTulajdonsag(hos,sc);
      chooseVarazslatok(hos, sc);
      chooseSereg(hos,sc);
      egysegElhelyezese(p, hos,sc);
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
    public static void chooseVarazslatok(Hos hos, Scanner sc){

        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Vásárolj varázslatokat! ----------------------------->"+Colors.ANSI_RESET);
        System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);

        Feltamasztas feltamasztas = new Feltamasztas();
        Tuzlabda tuzlabda = new Tuzlabda();
        Villamcsapas villamcsapas = new Villamcsapas();
        Tornado tornado = new Tornado();
        Nyilzapor nyilzapor = new Nyilzapor();

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
    public static void chooseSereg(Hos hos, Scanner sc){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Állítsd össze a sereged! ----------------------------->"+Colors.ANSI_RESET);
        Foldmuves foldmuves = new Foldmuves();
        Griff griff = new Griff();
        Ijasz ijasz = new Ijasz();
        int d;
        int db;
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
    public static void egysegElhelyezese(Palya p, Hos hos, Scanner sc){
        String oszlop = "";
        int sor = 0;
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Kezdődjék a játék! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
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
}
