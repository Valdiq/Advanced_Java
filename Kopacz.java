package Project_GUI;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kopacz extends Osoba implements IPracownik, Runnable, Comparable<Kopacz> {
    protected int iloscMachniecLopata;
    protected static boolean czyZdolnyDoPracy = true;

    public Kopacz(String imie, String nazwisko, int pesel, int nrTelefonu, double waga, int iloscMachniecLopata) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga);
        this.iloscMachniecLopata = iloscMachniecLopata;
    }

    static List<Kopacz> kopaczeNaUrlopie = new ArrayList<>();

    @Override
    public synchronized void run() {
        double randRazy = Math.round(5 + Math.random() * 20);
        double randSleep = Math.round(1 + Math.random() * 2);
        double randSzans = Math.round(1 + Math.random() * 100);
        int razy = 0;

        if (czyZdolnyDoPracy) {

            for (int i = 0; i <= randRazy; i++) {
                System.out.println("Kopacz " + imie + " machnął łopatą");
                razy++;
                iloscMachniecLopata++;
                Brygada.iloscMachniecLopataBrygady++;
                try {
                    Thread.sleep((int) (randSleep * 1000));
                } catch (InterruptedException e) {
                }

                if (razy == 15) {
                    i = (int) randRazy;
                    //czyZdolnyDoPracy = false;
                    try {
                        throw new zlamanaLopataException("Łopata zużyła się i pękła");
                    } catch (zlamanaLopataException e) {
                        e.printStackTrace();
                    }
                }

                if (randSzans == 1) {
                    i = (int) randRazy;
                    //czyZdolnyDoPracy = false;
                    try {
                        throw new zlamanaLopataException("Łopata była wadliwa i złamała si niespodziwanie w trakcie użytkowania");
                    } catch (zlamanaLopataException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public synchronized void kop() throws InterruptedException {
        run();
    }

    public void przerwanie() {
        czyZdolnyDoPracy = false;
    }


    public int getIloscMachniecLopata() {
        return iloscMachniecLopata;
    }

    public static boolean isCzyZdolnyDoPracy() {
        return czyZdolnyDoPracy;
    }

    //IPracownik
    @Override
    public String imie() {
        return imie;
    }

    @Override
    public String stanowisko() {
        return "Kopacz";
    }

    @Override
    public int pobierzPensje() {
        return iloscMachniecLopata * 200;
    }

    @Override
    public int powiedzIleRazyKopales() {
        return iloscMachniecLopata;
    }

    @Override
    public String powiedzCoRobisz() {
        if (czyZdolnyDoPracy) {
            return "Pracuję!";
        } else {
            return "Nie pracuję!";
        }
    }

    @Override
    public void zakonczDzialanie() {
        przerwanie();
    }

    @Override
    public void dodajSieDoBrygady(Brygada brygada) {
    }

    //COMPARABLE
    @Override
    public int compareTo(Kopacz o) {
        return this.imie.compareTo(o.imie());
    }

    @Override
    public String toString() {
        return "Kopacz{" +
                "imie='" + imie + '\'' +
                ", pesel=" + pesel +
                '}';
    }

    public static void comparableSort() {
        Collections.sort(kopaczeNaUrlopie);
        System.out.println(kopaczeNaUrlopie);
    }

}
