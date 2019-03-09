 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tranzakcio;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public abstract class Megbizas implements Tranzakcio{

    
    private int id = 0;
    private String inditoSzemely;
    private int osszeg;

    @Override
    public void egyenlegNovekszik() {
    }

    @Override
    public void egyenlegCsokkent() {
    }
    
    public Megbizas(String inditoSzemely, int osszeg) {
        this.id = setId();
        this.inditoSzemely = inditoSzemely;
        this.osszeg = osszeg;
    }
    
    private int setId() {
        id++;  
        return id;
    }

    public String getInditoSzemely() {
        return inditoSzemely;
    }

    public int getOsszeg() {
        return osszeg;
    }
    
    public void trancakcioIndit(){
        }

    @Override
    public String toString() {
        return "Tranzakcio2{" + "id=" + id + ", inditoSzemely=" + inditoSzemely + ", osszeg=" + osszeg + '}';
    }

    

    
 

    

}
