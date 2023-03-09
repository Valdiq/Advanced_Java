package Project_GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws nieUnikalnyPeselException {
        try {

            //Comparable (Kopacze na urlopie)
            Kopacz kopacz6 = new Kopacz("Mariot", "Sonmez", 12623589, 123123321, 63, 0);
            Kopacz kopacz7 = new Kopacz("Adam", "Rodriges", 12631789, 147852369, 85, 0);
            Kopacz kopacz8 = new Kopacz("Zeruf", "Hit", 12923789, 159753852, 74, 0);
            Kopacz kopacz9 = new Kopacz("Gabby", "Musk", 12641789, 564125723, 76, 0);
            Kopacz.kopaczeNaUrlopie.add(kopacz6);
            Kopacz.kopaczeNaUrlopie.add(kopacz7);
            Kopacz.kopaczeNaUrlopie.add(kopacz8);
            Kopacz.kopaczeNaUrlopie.add(kopacz9);

            System.out.print("Kopacze na urlopie: ");
            Kopacz.comparableSort();

            //Pracują
            Kopacz kopacz = new Kopacz("Vlad", "Deswid", 123456789, 123123321, 63, 0);
            Kopacz kopacz2 = new Kopacz("James", "Carlos", 987654321, 987654321, 87, 0);
            Kopacz kopacz3 = new Kopacz("Bob", "Rubik", 123789456, 542125556, 72, 0);
            Kopacz kopacz4 = new Kopacz("Steve", "Potter", 112547823, 123123321, 63, 0);
            Kopacz kopacz5 = new Kopacz("Kappy", "Rodriges", 132569823, 123123321, 63, 0);

            //Brygada.dodajPracowników
            List<IPracownik> najlepszyKopacze = new ArrayList<>();
            najlepszyKopacze.add(kopacz4);
            najlepszyKopacze.add(kopacz5);

            Thread kopThread = new Thread(kopacz);
            kopacz.kop();
            kopThread.join();

            Thread kop2Thread = new Thread(kopacz2);
            kopacz2.kop();
            kop2Thread.join();

            Thread kop3Thread = new Thread(kopacz3);
            kopacz3.kop();
            kop3Thread.join();

            Thread kop4Thread = new Thread(kopacz4);
            kopacz4.kop();
            kop4Thread.join();

            Thread kop5Thread = new Thread(kopacz5);
            kopacz5.kop();
            kop3Thread.join();

            //Architekci
            Architekt architekt = new Architekt("Carlos", "Nola", 741258963, 125458788, 88, new Specjalizacja("Hi-Tec"));
            Architekt architekt2 = new Architekt("Artos", "Ryzen", 365214987, 741255654, 75, new Specjalizacja("Modern"));


            //Brygada
            Brygada brygada = new Brygada();
            kopacz5.dodajSieDoBrygady(brygada);

            //Brygadzista
            Brygadzista brygadzista = new Brygadzista("Martin", "Musk", 125478569, 123654789, 92, 0, "MM", 3, brygada);
            Thread brygadz1 = new Thread(brygadzista);
            brygadzista.sprawdzCzyBrygadaNiezdolnaDoPracy();

            //Brygada
            Brygada.dodajPracownika(kopacz);
            Brygada.dodajPracownika(kopacz2);
            Brygada.dodajPracownika(kopacz3);
            Brygada.dodajPracownikow(najlepszyKopacze);
            Brygada.dodajPracownika(architekt);
            Brygada.dodajPracownika(architekt2);
            Brygada.setBrygadzista(brygadzista);

            //Koniec(Info)
            showInfo();

            System.out.println("Sriednia pensja kopacz: " + sriedniaPensja());
            System.out.println("Kopacze krórze zarabiają powyżej sriedniej pensji: ");

            Stream<IPracownik> naszaBrygada = Brygada.zespol.stream();
            Stream<IPracownik> filtredBrygada = naszaBrygada.filter(pr -> {
                boolean b = false;
                if (pr.stanowisko() == "Kopacz") {
                    b = pr.pobierzPensje() > sriedniaPensja();
                }
                return b;
            });
            filtredBrygada.forEach(System.out::println);

        } catch (nieUnikalnyPeselException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static int sriedniaPensja() {
        int iloscP = 0;
        int sumaP = 0;
        for (IPracownik x : Brygada.zespol) {
            if (x.stanowisko() == "Kopacz") {
                sumaP += x.pobierzPensje();
                iloscP++;
            }
        }
        return sumaP / iloscP;
    }

    public static void showInfo() {
        Brygada.showBrygada();
        System.out.println("Ilosc architekci: " + Brygada.ileArchitektow());
        System.out.println('\n' + "Brygada kopała " + Brygada.iloscMachniecLopataBrygady + " razy" + '\n');

        for (IPracownik p : Brygada.zespol) {
            if (p.stanowisko() == "Kopacz") {
                System.out.println("Kopacz " + p.imie() + " kopał " + p.powiedzIleRazyKopales() + " razy" + '\n' +
                        "Pensja kopaza " + p.imie() + " = " + p.pobierzPensje());
                System.out.println();
            }
            if (p.stanowisko() == "Arсhitekt") {
                System.out.println("Pensja architekta " + p.imie() + " = " + p.pobierzPensje());
                System.out.println();
            }
            if (p.stanowisko() == "Brygadzista") {
                System.out.println("Pensja brygadzisty " + p.imie() + " = " + p.pobierzPensje());
                System.out.println();
            }
        }
    }
}


