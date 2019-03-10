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
        if (tulajEllenorzes()) {
            if (MEGBIZAS.getTipus() == tipus.HUF_ATUTALAS) {
                hufAtutalas();
            }else {
                jovairas();
            }
            MEGBIZAS.setInditva(true);
            SZAMLA.addTortenet(MEGBIZAS);
        } else {
            System.err.println("Csak a tulajdonos indithat tranzakciót!");
        }
    }

    private boolean tulajEllenorzes() {
        return (SZAMLA.getTulajdonosok().size() >= 1 
                && SZAMLA.getTulajdonosok().contains(MEGBIZAS.getInditoSzemely()));
    }

    private void hufAtutalas() {
        System.out.println("hufAtutalas ");
        int ujEgyenleg = SZAMLA.getEgyenleg() + MEGBIZAS.getOsszeg() - MEGBIZAS.getKoltseg();
        SZAMLA.setEgyenleg(ujEgyenleg);
    }

    private void jovairas(){
        System.out.println("jovairas ");
        int ujEgyenleg = SZAMLA.getEgyenleg() - MEGBIZAS.getOsszeg() - MEGBIZAS.getKoltseg();
        SZAMLA.setEgyenleg(ujEgyenleg);
    }

    @Override
    public String toString() {
        return "Tranzakcio{" + "megbizas=" + MEGBIZAS + ", szamla=" + SZAMLA + '}';
    }

    
    
}
