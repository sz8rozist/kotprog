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

        Feltamasztas ellenfelFeltamasztas = new Feltamasztas();
        Tuzlabda ellenfelTuzlabda = new Tuzlabda();
        Villamcsapas ellenfelVillamcsapas = new Villamcsapas();
        Tornado ellenfelTornado = new Tornado();
        Nyilzapor ellenfelNyilzapor = new Nyilzapor();

        Foldmuves foldmuves = new Foldmuves();
        Griff griff = new Griff();
        Ijasz ijasz = new Ijasz();
        Lovag lovag = new Lovag();
        Pap pap = new Pap();

        Foldmuves ellenfelFoldmuves = new Foldmuves();
        Griff ellenfelGriff = new Griff();
        Ijasz ellenfelIjjasz = new Ijasz();
        Lovag ellenfelLovag = new Lovag();
        Pap ellenfelPap = new Pap();

        chooseLevel(nehezseg, hos, sc);
        choosHosTulajdonsag(hos,sc);
        chooseVarazslatok(hos, sc, feltamasztas, tuzlabda, villamcsapas, tornado,nyilzapor);
        do{
            chooseSereg(hos,sc, foldmuves, griff, ijasz);
        }while(foldmuves.getDarab() == 0 && griff.getDarab() == 0 && ijasz.getDarab() == 0);
        ellenfelBeallitas(ellenfelFeltamasztas, ellenfelTuzlabda, ellenfelVillamcsapas, ellenfelTornado, ellenfelNyilzapor, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz, ellenfel, rnd);
        egysegElhelyezese(p, hos,sc, ellenfel, rnd, foldmuves, griff, ijasz, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz);
        hosAdatok(hos);
        ellenfelAdatai(ellenfel, ellenfelFeltamasztas, ellenfelNyilzapor, ellenfelTornado, ellenfelTuzlabda, ellenfelVillamcsapas, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz);
        jatek(hos, ellenfel, p, sc, foldmuves, griff, ijasz, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz, feltamasztas, nyilzapor, tornado, tuzlabda, villamcsapas);
    }
    public static void chooseLevel(int nehezseg, Hos hos, Scanner sc){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Válaszd ki a nehézségi szintet! ----------------------------->"+Colors.ANSI_RESET);
        System.out.println("1 - Könnyű");
        System.out.println("2 - Közepes");
        System.out.println("3 - Nehéz");
        System.out.println(Colors.ANSI_BLUE +"<------------------------------------------------------------------------------------------->"+ Colors.ANSI_RESET);

        do{
            System.out.print("Válaszd ki a nehézségi szintet: ");
            nehezseg = sc.nextInt();
        } while(nehezseg != 1 && nehezseg != 2 && nehezseg != 3);


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
            System.out.println("10 - Tovább a varázslatok megvásárlásához!");
            System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
            System.out.print("Melyik tulajdonságpontot fejleszted?: ");
            in = sc.nextInt();
            hos.setTulajdonsagpontok(in);
        }while(in != 10);
    }
    public static void chooseVarazslatok(Hos hos, Scanner sc, Feltamasztas feltamasztas,Tuzlabda tuzlabda, Villamcsapas villamcsapas, Tornado tornado, Nyilzapor nyilzapor){

        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Vásárolj varázslatokat! ----------------------------->"+Colors.ANSI_RESET);
        int darab;
        int darab2;
        do{
            System.out.println("Varázslatok");
            System.out.println("1 - Feltámasztás (ára: " + feltamasztas.getAr() + ") (manaköltsége: "+ feltamasztas.getMana()+ ")");
            System.out.println("2 - Tűzlabda (ára: " + tuzlabda.getAr() + ") (manaköltsége: "+ tuzlabda.getMana()+ ")");
            System.out.println("3 - Villámcsapás (ára: " + villamcsapas.getAr() + ") (manaköltsége: "+ villamcsapas.getMana()+ ")");
            System.out.println("4 - Tornádó (ára: " + tornado.getAr() + ") (manaköltsége: "+ tornado.getMana()+ ")");
            System.out.println("5 - Nyílzápor (ára: " + nyilzapor.getAr() + ") (manaköltsége: "+ nyilzapor.getMana()+ ")");
            System.out.println("10 - Tovább a sereg összeállításához!");
            System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
            System.out.print("Melyik varázslatot szeretnéd?: ");
            darab = sc.nextInt();
            switch(darab){
                case 1 -> {
                    System.out.print("Hány darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(!hos.vanelegArany(feltamasztas.getAr() * darab2)){
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                    feltamasztas.vasarol(hos,darab2);
                }
                case 2 -> {
                    System.out.print("Hány darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tuzlabda.getAr()  * darab2)){
                        tuzlabda.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 3 -> {
                    System.out.print("Hány darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(villamcsapas.getAr() * darab2)){
                        villamcsapas.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 4 -> {
                    System.out.print("Hány darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tornado.getAr() * darab2)){
                        tornado.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
                case 5 -> {
                    System.out.print("Hány darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(nyilzapor.getAr() * darab2)){
                        nyilzapor.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                    }
                }
            }
            System.out.println(feltamasztas.getNev() + feltamasztas.getDarab());
        }while(darab != 10);
    }
    public static void chooseSereg(Hos hos, Scanner sc, Foldmuves foldmuves, Griff griff, Ijasz ijasz){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Állítsd össze a sereged! ----------------------------->"+Colors.ANSI_RESET);
        int d;
        int db;
            do{
                System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
                System.out.println("1 - "+foldmuves.getNev());
                System.out.println("2 - "+griff.getNev());
                System.out.println("3 - "+ijasz.getNev());
                System.out.println("10 - Elhelyezem az egységeimet a pályán!");
                System.out.print("Melyik egységet szeretnéd?: ");
                d = sc.nextInt();
                switch (d) {
                    case 1 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(foldmuves.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        foldmuves.egysegVasarlas(hos,db);
                    }
                    case 2 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(griff.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        griff.egysegVasarlas(hos,db);
                    }
                    case 3 -> {
                        System.out.print("Hány darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(ijasz.getAr() * db)){
                            System.err.println("Nem elegendő az aranyad a vásárláshoz!");
                        }
                        ijasz.egysegVasarlas(hos,db);
                    }
                }
            }while(d != 10);
    }
    public static void egysegElhelyezese(Palya p, Hos hos, Scanner sc, Hos ellenfel, Random rnd, Foldmuves f, Griff g, Ijasz i, Foldmuves ef, Griff eg, Ijasz ei){
        String oszlop = "";
        int sor = 0;
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Helyezd el az egységeidet a pályán! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        System.out.println("Helyezd el a pályán az egységeidet!");
        if(f.getDarab() > 0){
            do{
                System.out.println("Hova tegyük a "+ f.getNev() + " egységet?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(f, oszlop, sor));

        }
        if(g.getDarab() > 0){
            do{
                System.out.println("Hova tegyük a "+ g.getNev() + " egységet?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(g, oszlop, sor));
        }
        if(i.getDarab() > 0){
            do{
                System.out.println("Hova tegyük a "+ i.getNev() + " egységet?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(i, oszlop, sor));
        }
        if(ef.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(ef, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        if(eg.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(eg, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        if(ei.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(ei, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        p.printPalya();
    }
    public static void ellenfelBeallitas(Feltamasztas feltamasztas, Tuzlabda tuzlabda, Villamcsapas villamcsapas,Tornado tornado, Nyilzapor nyilzapor, Foldmuves foldmuves, Griff griff, Ijasz ijasz, Hos ellenfel, Random rnd){
        feltamasztas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        tuzlabda.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        villamcsapas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        tornado.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        nyilzapor.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);

        foldmuves.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
        griff.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
        ijasz.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
    }
    public static void jatek(Hos hos, Hos ellenfel, Palya p, Scanner sc, Foldmuves f, Griff g, Ijasz i, Foldmuves ellenfelF, Griff ellenfelGriff, Ijasz ellenfelIjasz, Feltamasztas feltamasztas, Nyilzapor nyilzapor, Tornado tornado, Tuzlabda tuzlabda, Villamcsapas villamcsapas){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Kezdődjön a játék! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        int kor = 0;
        String karakter;
        int szam = 0;
        int hanyEgyseg = 0;
        int merre = 0;
        int h = 0;
        int kivalasztottVarazslat = 0;
        int megtamadottEgyseg = 0;
            kor++;
            Egyseg legnagyobbKezdemenyezesu = null;
            if(i.getDarab() > 0){
                legnagyobbKezdemenyezesu  = new Ijasz();
            }
        if(f.getDarab() > 0){
            legnagyobbKezdemenyezesu  = new Foldmuves();
        }
        if(g.getDarab() > 0){
            legnagyobbKezdemenyezesu  = new Griff();
        }
            System.out.println(Colors.ANSI_PURPLE+"Kör: "+kor+Colors.ANSI_RESET);
            do{
                System.out.print(Colors.ANSI_GREEN + "Egységgel szeretnél lépni vagy a hősöddel? (e/h): "+ Colors.ANSI_RESET);
                karakter = sc.next();
            }while(!karakter.equals("e") && !karakter.equals("h"));
            loop : switch (karakter) {
                case "e" -> {
                    System.out.println("1 - Mozgás");
                    System.out.println("2 - Várakozás");
                    System.out.println("3 - Támadás");
                    System.out.print("Mit szeretnél tenni az egységgel?: ");
                    szam = sc.nextInt();
                    if (szam == 1) {
                        do{
                            System.out.print("Merre mozogjon? (1 - előre, 2 - hátra, 3 - jobbra, 4 - balra): ");
                            merre = sc.nextInt();
                            System.out.print("Hány egységet mozogjon?: ");
                            hanyEgyseg = sc.nextInt();
                        } while(!legnagyobbKezdemenyezesu.mozgas(hanyEgyseg, merre, p.getPalya()));
                    }
                    if(szam == 3){
                        int melyik = 0;
                            System.out.print("Melyik egységet támadjuk?: ");
                            System.out.println("1 - "+ellenfelF.getNev() + " (életerő: "+ ellenfelF.getEletero()+")");
                            System.out.println("2 - "+ellenfelGriff.getNev() + " (életerő: "+ ellenfelGriff.getEletero()+")");
                            System.out.println("3 - "+ellenfelIjasz.getNev() + " (életerő: "+ ellenfelIjasz.getEletero()+")");
                            melyik = sc.nextInt();
                            if(melyik == 1){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelF,hos,ellenfel);
                            }
                            if(melyik == 2){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelGriff,hos,ellenfel);
                            }
                            if(melyik == 3){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelIjasz,hos,ellenfel);
                            }
                    }
                    if(szam == 2){
                        break loop;
                    }
                }
                case "h" -> {
                    System.out.print("1 - Támadás / 2 - Varázslás: ");
                    h = sc.nextInt();
                    if (h == 1) {
                        int c = 0;
                        System.out.println("Az ellenfél egységei: ");
                        System.out.println("1 - "+ellenfelF.getNev() + " (életerő: "+ ellenfelF.getEletero()+")");
                        System.out.println("2 - "+ellenfelGriff.getNev() + " (életerő: "+ ellenfelGriff.getEletero()+")");
                        System.out.println("3 - "+ellenfelIjasz.getNev() + " (életerő: "+ ellenfelIjasz.getEletero()+")");
                        System.out.print("Melyik egységet támadjuk: ");
                        megtamadottEgyseg = sc.nextInt();
                        if(megtamadottEgyseg == 1){
                            hos.hosTamad(ellenfelF);
                        }
                        if(megtamadottEgyseg == 2){
                            hos.hosTamad(ellenfelGriff);
                        }
                        if(megtamadottEgyseg == 3){
                            hos.hosTamad(ellenfelIjasz);
                        }

                    } else if (h == 2) {
                        System.out.println("Felhasználható varázslatok");
                        if(villamcsapas.getDarab() > 0){
                            System.out.println("1 - "+villamcsapas.getNev() + " (mana: "+ villamcsapas.getMana()+")");
                        }
                        if(feltamasztas.getDarab() > 0){
                            System.out.println("2 - "+feltamasztas.getNev() + " (mana: "+ feltamasztas.getMana()+")");
                        }
                        if(nyilzapor.getDarab() > 0){
                            System.out.println("3 - "+nyilzapor.getNev() + " (mana: "+ nyilzapor.getMana()+")");
                        }
                        if(tuzlabda.getDarab() > 0){
                            System.out.println("4 - "+tuzlabda.getNev() + " (mana: "+ tuzlabda.getMana()+")");
                        }
                        if(tornado.getDarab() > 0){
                            System.out.println("5 - "+tornado.getNev() + " (mana: "+ tornado.getMana()+")");
                        }
                        System.out.print("Melyik varázslatot választod?: ");
                        kivalasztottVarazslat = sc.nextInt();
                        switch (kivalasztottVarazslat){
                            case 1:
                                System.out.println("Ellenfél egységei: ");
                                System.out.println("1 - "+ellenfelF.getNev() + " (életerő: "+ ellenfelF.getEletero()+")");
                                System.out.println("2 - "+ellenfelGriff.getNev() + " (életerő: "+ ellenfelGriff.getEletero()+")");
                                System.out.println("3 - "+ellenfelIjasz.getNev() + " (életerő: "+ ellenfelIjasz.getEletero()+")");
                                System.out.print("Melyik egységre használnod a varázslást?: ");
                                megtamadottEgyseg = sc.nextInt();
                                if(megtamadottEgyseg == 1){
                                    villamcsapas.villamcsapas(hos, ellenfelF);
                                }
                                if(megtamadottEgyseg == 2){
                                    villamcsapas.villamcsapas(hos, ellenfelGriff);
                                }
                                if(megtamadottEgyseg == 3){
                                    villamcsapas.villamcsapas(hos, ellenfelIjasz);
                                }
                                break;
                            case 2:
                                System.out.println("Az egységeid ");
                                if(f.getDarab() > 0){
                                    System.out.println("1 - "+f.getNev() + " (életerő: "+ f.getEletero()+")");
                                }
                                if(g.getDarab() > 0){
                                    System.out.println("2 - "+g.getNev() + " (életerő: "+ g.getEletero()+")");
                                }
                                if(i.getDarab() > 0){
                                    System.out.println("3 - "+i.getNev() + " (életerő: "+ i.getEletero()+")");
                                }
                                System.out.print("Melyik egységre használnod a varázslást?: ");
                                megtamadottEgyseg = sc.nextInt();
                                if(megtamadottEgyseg == 1){
                                    feltamasztas.feltamasztas(hos, f);
                                }
                                if(megtamadottEgyseg == 2){
                                    feltamasztas.feltamasztas(hos, g);
                                }
                                if(megtamadottEgyseg == 3){
                                    feltamasztas.feltamasztas(hos, i);
                                }
                                break;
                            case 3:
                                nyilzapor.nyilzapor(hos, ellenfelF, ellenfelGriff, ellenfelIjasz);
                                break;
                            case 4: /*tuzlabda*/ break;
                            case 5:
                                tornado.tornado(hos, ellenfelF, ellenfelGriff, ellenfelIjasz);
                                break;
                        }
                    }
                }
            }
            p.printPalya();
    }
    public static void hosAdatok(Hos h){
        System.out.println();
        System.out.println(Colors.ANSI_BLUE+"Tulajdonságpontjaim "+Colors.ANSI_RESET);
        System.out.println("Támadás: "+h.getTamadas());
        System.out.println("Védekezés: "+h.getVedekezes());
        System.out.println("Varázserő: "+h.getVarazsero());
        System.out.println("Tudás: "+h.getTudas());
        System.out.println("Morál: "+h.getMoral());
        System.out.println("Szerencse: "+h.getSzerencse());
        System.out.println("Mana: "+h.getMana());
    }
    public static void ellenfelAdatai(Hos h, Feltamasztas f, Nyilzapor ny, Tornado t, Tuzlabda tu, Villamcsapas v, Foldmuves fold, Griff g, Ijasz i){
        System.out.println();
        System.out.println(Colors.ANSI_BLUE + "Az ellenfél adatai"+ Colors.ANSI_RESET);
        System.out.println("Támadás: "+h.getTamadas());
        System.out.println("Védekezés: "+h.getVedekezes());
        System.out.println("Varázserő: "+h.getVarazsero());
        System.out.println("Tudás: "+h.getTudas());
        System.out.println("Morál: "+h.getMoral());
        System.out.println("Szerencse: "+h.getSzerencse());
        System.out.println("Mana: "+h.getMana());

        System.out.println(Colors.ANSI_BLUE +"Az ellenfél varázserői:"+ Colors.ANSI_RESET);
        if(f.getDarab() != 0){
            System.out.println(f.getNev());
        }
        if(ny.getDarab() != 0){
            System.out.println(ny.getNev());
        }
        if(t.getDarab() != 0){
            System.out.println(t.getNev());
        }
        if(tu.getDarab() != 0){
            System.out.println(tu.getNev());
        }
        if(v.getDarab() != 0){
            System.out.println(v.getNev());
        }
        System.out.println(Colors.ANSI_BLUE +"Az ellenfél egységei:"+ Colors.ANSI_RESET);
        if(fold.getDarab() != 0){
            System.out.println(fold.getNev());
        }
        if(g.getDarab() != 0){
            System.out.println(g.getNev());
        }
        if(i.getDarab() != 0){
            System.out.println(i.getNev());
        }
    }
}
