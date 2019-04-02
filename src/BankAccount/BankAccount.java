/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccount;

import Clients.Client;
import ItemLists.BankAccountList;
import Util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FZs
 */
public class BankAccount {

    private final int MAX_OWNER = 3;
    
    private int iD = 11770;
    private double ballance = 0;
    private List<Client> ownerList;

    BankAccount(Client client) {
        ownerList = new ArrayList<>();
        ownerList.add(client);
    }

    int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
    
    public double getBallance() {
        return ballance;
    }

    public List<Client> getOwnerList() {
        List<Client> result = new ArrayList<>();
        for (int i = 0; i < ownerList.size(); i++) {
            result.add(ownerList.get(i));
        }
        return result;
    }

    public void addOwnerList(Client client) {
        if (!Util.isExistingClient(ownerList, client)
                && ownerList.size() < MAX_OWNER) {
            ownerList.add(client);
        }
    }

    public void takeOutOwnerList(Client client) {
        boolean b = true;
        int i = 0;
        while (b && i < ownerList.size()) {
            if (Util.isExistingClient(ownerList, client)) {
                ownerList.remove(i);
                b = false;
            }else{
                i++;
            }
        }
    }
    
    public void setBallance(double ballance) {
        this.ballance = ballance;
    }

    public void showOwnerList() {
        StringBuilder sb = new StringBuilder();
        sb.append("A azámlához tartozó tulajdonosok listája:")
                .append(System.lineSeparator());
        for (int i = 0; i < ownerList.size(); i++) {
            Client result = ownerList.get(i);
            sb.append("Számlatulajdonos neve: ")
                    .append(result.getName())
                    .append(" Anyja neve: ")
                    .append(result.getMotherName())
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "BankAccount{" + "iD=" + iD + ", ballance=" + ballance + ", ownerList=" + ownerList + '}';
    }

    
    
    
    

}
