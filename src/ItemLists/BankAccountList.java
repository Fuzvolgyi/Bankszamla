/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ItemLists;

import BankAccount.BankAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FZs
 */
public class BankAccountList {
    
    private static List<BankAccount> accountList = new ArrayList<>();
    
    private BankAccountList(){
        
    }
    
    public static void addBankAccount( BankAccount item){
        accountList.add(item);
    }
    
    public static int accountListSize(){
        return accountList.size();
    }
    
    public static void showBankAccountList(){
        StringBuilder sb = new StringBuilder();
        sb.append("A bankszámlák listája:")
                .append(System.lineSeparator());
        for (int i = 0; i < accountList.size(); i++) {
            sb.append(accountList.get(i).toString())
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
