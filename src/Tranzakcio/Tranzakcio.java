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

    private final Megbizas MEGBIZAS;
    private final BankSzamla SZAMLA;

    public Tranzakcio(Megbizas megbizasPeldany, BankSzamla bankSzamla) {
        MEGBIZAS = megbizasPeldany;
        SZAMLA = bankSzamla;
    }

    public void tranzakcioIndit() {

        if (SZAMLA.tulajEllenorzes(MEGBIZAS.getInditoSzemely())) {
            if (MEGBIZAS.getTipus() == tipus.HUF_ATUTALAS) {
                hufAtutalas();
            } else {
                jovairas();
            }
        }
    }

    private void hufAtutalas() {
        System.out.println("hufAtutalas ");
        int ujEgyenleg = SZAMLA.getEgyenleg() + MEGBIZAS.getOsszeg() - MEGBIZAS.getKoltseg();
        SZAMLA.setEgyenleg(ujEgyenleg);
        MEGBIZAS.setInditva(true);
        SZAMLA.addTortenet(MEGBIZAS);
    }

    private void jovairas() {
        int ujEgyenleg = SZAMLA.getEgyenleg() - MEGBIZAS.getOsszeg() - MEGBIZAS.getKoltseg();
        if (ujEgyenleg > 0) {
            System.out.println("jovairas ");
            SZAMLA.setEgyenleg(ujEgyenleg);
            MEGBIZAS.setInditva(true);
            SZAMLA.addTortenet(MEGBIZAS);
        } 
        
        
        
    }

    @Override
    public String toString() {
        return "Tranzakcio{" + "megbizas=" + MEGBIZAS + ", szamla=" + SZAMLA + '}';
    }

}
