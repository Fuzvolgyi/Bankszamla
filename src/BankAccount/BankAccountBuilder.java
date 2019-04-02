/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankAccount;

import Clients.Client;
import Interface.IBankAccount;
import ItemLists.BankAccountList;
import ItemLists.ClientList;

/**
 *
 * @author FZs
 */
public class BankAccountBuilder implements IBankAccount{

    @Override
    public BankAccount getBankAccount(Client client) {
        if (client == null) {
            return null;
        } else {
            BankAccount result = new BankAccount(client);
            ClientList.addClient(client);
            BankAccountList.addBankAccount(result);
            result.setiD(1177 + BankAccountList.accountListSize());
            return result;
        }
    }
    
    

    @Override
    public void showAccount(BankAccount item) {
        StringBuilder sb = new StringBuilder();
        sb.append(item.getiD())
                .append(" Azonosítóval rendelkező számla adatai.")
                .append(System.lineSeparator())
                .append("Egyenlege: ")
                .append(item.getBallance())
                .append(" HUF ")
                .append(System.lineSeparator())
                .append("Tulajdonosok listája :") 
                .append(item.getOwnerList().toString())
                .append(System.lineSeparator());
        System.out.println(sb);
    }

    
    
    
    
    
    
    
    
    
}
