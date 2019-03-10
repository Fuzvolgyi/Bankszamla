 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Megbizas;

import Tranzakcio.tipus;

/**
 *
 * @author FZs
 */
public class Megbizas {

    private int id = 1;
    private tipus tipus;
    private String inditoSzemely;
    private int osszeg;
    private double tranzakciosDij = 0.05;
    private double illetek = 0.003;
    private int koltseg;
    private boolean inditva = false;

    public Megbizas(String inditoSzemely, int osszeg, tipus tipus) {
        this.id = beallaitId();
        this.tipus = tipus;
        this.inditoSzemely = inditoSzemely;
        this.osszeg = osszeg;
        this.koltseg = koltsegSzamitas();
        this.illetek = getIlletek();
        this.inditva = inditva;
    }

    public boolean isInditva() {
        return inditva;
    }

    public void setInditva(boolean inditva) {
        this.inditva = inditva;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKoltseg() {
        return koltseg;
    }

    private double getIlletek() {
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
        this.osszeg = osszeg;
    }

    public tipus getTipus() {
        return tipus;
    }

    private int beallaitId() {                                                  // to do
       int eredmeny = id;
       return eredmeny;
    }
    
    private int koltsegSzamitas() {
        double szam = osszeg * tranzakciosDij + getIlletek();
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
