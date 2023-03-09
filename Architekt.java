package Project_GUI;

import java.util.List;
import java.util.stream.Stream;

public class Architekt extends Osoba implements IPracownik {
    private Specjalizacja specjalizacja;

    public Architekt(String imie, String nazwisko, int pesel, int nrTelefonu, double waga, Specjalizacja specjalizacja) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga);
        this.specjalizacja = specjalizacja;
    }

    public Specjalizacja getSpecjalizacja() {
        return specjalizacja;
    }

    //Ipracownik
    @Override
    public String imie() {
        return imie;
    }

    @Override
    public String stanowisko() {
        return "Arсhitekt";
    }

    @Override
    public int pobierzPensje() {
        return 5000;
    }

    @Override
    public int powiedzIleRazyKopales() {
        return 0;
    }

    @Override
    public String powiedzCoRobisz() {
        return "Rysuje...";
    }

    @Override
    public void zakonczDzialanie() {

    }

    @Override
    public void dodajSieDoBrygady(Brygada brygada) {
    }
}
