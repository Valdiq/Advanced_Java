package Project_GUI;

import java.util.HashMap;
import java.util.Map;

public abstract class Osoba {
    protected String imie;
    protected String nazwisko;
    protected Integer pesel;
    protected int nrTelefonu;
    protected double waga;

    private static Map<Integer, Osoba> osoba = new HashMap<Integer, Osoba>();

    public Osoba(String imie, String nazwisko, Integer pesel, int nrTelefonu, double waga) throws nieUnikalnyPeselException {
        if (!osoba.keySet().contains(pesel)) {
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.nrTelefonu = nrTelefonu;
            this.waga = waga;
            this.pesel = pesel;
            osoba.put(pesel, this);
        } else {
            throw new nieUnikalnyPeselException();
        }
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Integer getPesel() {
        return pesel;
    }

    public int getNrTelefonu() {
        return nrTelefonu;
    }

    public double getWaga() {
        return waga;
    }
}
