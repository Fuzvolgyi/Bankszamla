/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tranzakcio;

import Megbizas.Megbizas;
import Szamla.BankSzamla;

/**
 *
 * @author FZs
 */
public class Tranzakcio {

    public Tranzakcio() {
    }
    
    public void tranzakcioIndit(Megbizas megbizas, BankSzamla szamla) {
        if (tulajEllenorzes(megbizas.getInditoSzemely(), szamla)) {
            if (megbizas.getTipus() == tipus.HUF_ATUTALAS) {
                hufAtutalas(megbizas, szamla);
            }
            if (megbizas.getTipus() == tipus.JOVAIRAS) {
                jovairas(megbizas, szamla);
            }
            megbizas.setInditva(true);
            szamla.addTortenet(megbizas);
        } else {
            System.err.println("Csak a tulajdonos indithat tranzakciót!");
        }
    }

    private boolean tulajEllenorzes(String nev, BankSzamla szamla) {
        return (szamla.getTulajdonosok().contains(nev) && szamla.getTulajdonosok().size() >= 1);
    }

    private void hufAtutalas(Megbizas megbizas, BankSzamla szamla) {
        System.out.println("hufAtutalas ");
        int ujEgyenleg = szamla.getEgyenleg() + megbizas.getOsszeg() - megbizas.getKoltseg();
        szamla.setEgyenleg(ujEgyenleg);
    }

    private void jovairas(Megbizas megbizas, BankSzamla szamla){
        System.out.println("jovairas ");
        int ujEgyenleg = szamla.getEgyenleg() - megbizas.getOsszeg() - megbizas.getKoltseg();
        szamla.setEgyenleg(ujEgyenleg);
    }
    
    
}
