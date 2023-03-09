package Project_GUI;

public interface IPracownik {
    public String imie();

    public String stanowisko();

    public int pobierzPensje();

    public int powiedzIleRazyKopales();

    public String powiedzCoRobisz();

    public void zakonczDzialanie();

    public void dodajSieDoBrygady(Brygada brygada);
}
