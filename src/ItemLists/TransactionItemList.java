/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemLists;

import Transaction.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FZs
 */
public class TransactionItemList {

    private static List<Transaction> transactionItemList = new ArrayList<Transaction>();

    private TransactionItemList() {
    }

    public static void addTransactionItem(Transaction item) {
        transactionItemList.add(item);
    }

    public List<Transaction> getTransactionItemList() { 
        List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactionItemList) {
            result.add(transaction);
        }
        return result;
    }

    public static void showTransactionItems() {
        StringBuilder sb = null;
        sb = new StringBuilder();
        sb.append("Tranzakciók listája:")
                .append(System.lineSeparator());
        for (int i = 0; i < transactionItemList.size(); i++) {
            Transaction item = transactionItemList.get(i);
            sb.append(i + 1)
                    .append(". tranzakció:")
                    .append(System.lineSeparator())
                    .append(item.getClient().getName())
                    .append(" indított ")
                    .append(item.getType())
                    .append(" tranzakciót ")
                    .append(item.getAmount())
                    .append(" HUF összegben. ")
                    .append(System.lineSeparator())
                    .append("A trancakció költség: ")
                    .append(item.getCost())
                    .append(" HUF. A fizetendő illeték összeg:  ")
                    .append(item.getDuty())
                    .append(" HUF.")
                    .append(System.lineSeparator());

        }
        System.out.println(sb);
    }

}
