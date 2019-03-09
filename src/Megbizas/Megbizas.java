 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Megbizas;

import Szamla.BankSzamla;
import Tranzakcio.tipus;
import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public class Megbizas {

    private int id = 0;
    private tipus tipus;
    private String inditoSzemely;
    private int osszeg;
    private double tranzakciosDij = 0.05;
    private double illetek = 0.003;
    private int koltseg;
    private boolean inditva = false;

    public Megbizas(String inditoSzemely, int osszeg, tipus tipus) {
        this.id = setId();
        this.tipus = tipus;
        this.inditoSzemely = inditoSzemely;
        this.osszeg = osszeg;
        this.koltseg = koltsegSzamitas(osszeg);
        this.illetek = getIlletek(osszeg);
        this.inditva = inditva;
    }

    public boolean isInditva() {
        return inditva;
    }

    public void setInditva(boolean inditva) {
        this.inditva = inditva;
    }

    private int setId() {
        id++;
        return id;
    }

    public int getKoltseg() {
        return koltseg;
    }

    private double getIlletek(int osszeg) {
        double szam = osszeg * illetek;
        return szam;
    }

    public String getInditoSzemely() {
        return inditoSzemely;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        if (osszeg < 1) {
            System.err.println("Csak 0-nál nagyob összegre lehet megbízást indítani!");
        }
        this.osszeg = osszeg;
    }

    
    
    public tipus getTipus() {
        return tipus;
    }

    private int koltsegSzamitas(int osszeg) {
        double szam = osszeg * tranzakciosDij + getIlletek(osszeg);
        return (int) szam;
    }
    
    @Override
    public String toString() {
        return "Megbizas{" + "id=" + id + ", tipus=" + tipus
                + ", inditoSzemely=" + inditoSzemely + ", osszeg=" + osszeg
                + ", tranzakciosDij=" + tranzakciosDij + ", illetek=" + illetek
                + ", koltseg=" + koltseg + ", megbízás indítva=" + inditva + '}';
    }

}
