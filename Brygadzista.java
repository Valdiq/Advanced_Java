package Project_GUI;

public class Brygadzista extends Kopacz implements IPracownik, Runnable {
    private String pseudonim;
    private int dlugoscZmiany;
    private Brygada brygada;

    public Brygadzista(String imie, String nazwisko, int pesel, int nrTelefonu, double waga, int iloscMachniecLopata, String pseudonim, int dlugoscZmiany, Brygada brygada) throws nieUnikalnyPeselException {
        super(imie, nazwisko, pesel, nrTelefonu, waga, iloscMachniecLopata);
        this.pseudonim = pseudonim;
        this.dlugoscZmiany = dlugoscZmiany;
        this.brygada = brygada;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(dlugoscZmiany * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Brygada.zespol.contains(Kopacz.czyZdolnyDoPracy)) {
            System.out.println("Brygada zdolna do pracy!");

        } else if (!Brygada.zespol.contains(Kopacz.czyZdolnyDoPracy)) {
            try {
                throw new brygadaNieZdolnaDoPracyException("Brygada nie zdolna do pracy");
            } catch (brygadaNieZdolnaDoPracyException e) {
                e.printStackTrace();
            }
        }
    }

    public void sprawdzCzyBrygadaNiezdolnaDoPracy() {
        run();
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public int getDlugoscZmiany() {
        return dlugoscZmiany;
    }

    public Brygada getBrygada() {
        return brygada;
    }


    //Ipracownik
    @Override
    public int pobierzPensje() {
        return 4000;
    }

    @Override
    public int powiedzIleRazyKopales() {
        return 0;
    }

    @Override
    public String powiedzCoRobisz() {
        return "Zarządam";
    }

    @Override
    public void zakonczDzialanie() {
        przerwanie();
    }

    @Override
    public String stanowisko() {
        return "Brygadzista";
    }

    @Override
    public void dodajSieDoBrygady(Brygada brygada) {
    }
}
