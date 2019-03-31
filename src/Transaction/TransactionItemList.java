/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Transaction;

import Interface.TransactionItem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FZs
 */
public class TransactionItemList {
    private List<TransactionItem> transactionItemList = new ArrayList<>();
    
    public void addTransactionItemList(TransactionItem item){
        transactionItemList.add(item);
    }
    
    public void showTransactionItems(){
        StringBuilder sb;
        for (TransactionItem transactionItem : transactionItemList) {
            sb = new StringBuilder();
            sb.append(transactionItem.client().getName())
                    .append(" indított ")
                    .append(transactionItem.transction().getType().toString())
                    .append(" tranzakciót ")
                    .append(transactionItem.transction().AMOUNT)
                    .append(" összegben. ")
                    .append(System.lineSeparator())
                    .append("A trancakció költség: ")
                    .append(transactionItem.transction().getCost())
                    .append("A fizetendő illeték összeg:  ")
                    .append(transactionItem.transction().getDuty());
        }
        
        }
    }
    

