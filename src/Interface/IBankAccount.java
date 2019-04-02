/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import BankAccount.BankAccount;
import Clients.Client;

/**
 *
 * @author FZs
 */
public interface IBankAccount {
    
    public BankAccount getBankAccount(Client client);
    public void showAccount(BankAccount item);
    
}
