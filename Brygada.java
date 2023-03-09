package Project_GUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Brygada {
    private String brygadzista;
    private static int ilePracownikow;
    private static int pracownicy;
    private static int maksymalnaIloscPracownikow = 10;
    protected static int iloscMachniecLopataBrygady;

    static List<IPracownik> zespol = new ArrayList<>();

    public static int ileArchitektow() {
        int ileArchitektow = 0;
        for (IPracownik prac : zespol) {
            if (prac.stanowisko() == "Arсhitekt") {
                ileArchitektow++;
            }
        }
        return ileArchitektow;
    }

    public static boolean czyPelnaBrygada() {
        if (ilePracownikow == maksymalnaIloscPracownikow) {
            return true;
        } else {
            return false;
        }
    }

    public static void dodajPracownika(IPracownik pracownik) {
        if (!czyPelnaBrygada()) {
            zespol.add(pracownik);
            ilePracownikow++;
        } else {
            System.out.println("Brygada jest pelna");
        }
    }

    public static void dodajPracownikow(List<IPracownik> pr) {
        if ((ilePracownikow + pr.size()) < maksymalnaIloscPracownikow) {
            for (IPracownik prac : pr) {
                zespol.add(prac);
                ilePracownikow++;
            }
        } else {
            System.out.println("Brygada jest pelna");
        }
    }

    public static void setBrygadzista(Brygadzista brygadzista) {
        if (!czyPelnaBrygada()) {
            zespol.add(brygadzista);
        } else {
            System.out.println("Brygada jest pelna");
        }
    }

    public static void showBrygada() {
        System.out.println("Pracowniki: ");
        for (IPracownik p : zespol) {
            System.out.println(p.stanowisko() + ": " + p.imie() + " ");
        }
    }

    public int getIloscMachniecLopataBrygady() {
        return iloscMachniecLopataBrygady;
    }

}
