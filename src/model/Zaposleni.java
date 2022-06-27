package model;

import java.io.Serializable;

public class Zaposleni implements Serializable {

    private String ime;
    private String adresa;
    private int zaposleni_id;
    private int broj_godina;
    private double visina_dohotka;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleni_id, String ime, String adresa, int broj_godina, double visina_dohotka) {
        this.ime = ime;
        this.adresa = adresa;
        this.zaposleni_id = zaposleni_id;
        this.broj_godina = broj_godina;
        this.visina_dohotka = visina_dohotka;
    }

    public String getIme() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getZaposleni_id() {
        return zaposleni_id;
    }
    public void setZaposleni_id(int zaposleni_id) {
        this.zaposleni_id = zaposleni_id;
    }

    public int getBroj_godina() {
        return broj_godina;
    }
    public void setBroj_godina(int broj_godina) {
        this.broj_godina = broj_godina;
    }

    public double getVisina_dohotka() {
        return visina_dohotka;
    }
    public void setVisina_dohotka(double visina_dohotka) {
        this.visina_dohotka = visina_dohotka;
    }

    @Override
    public String toString() {
        return zaposleni_id +
                ", " + ime +
                ", " + adresa +
                ", " + broj_godina +
                ", " + visina_dohotka +
                "\n";
    }
}
