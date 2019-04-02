/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import BankAccount.BankAccount;
import Clients.Client;
import ItemLists.TransactionItemList;

/**
 *
 * @author FZs
 */
public class TransactionFactory {

    public Transaction getTransaction(TransactionType type, int amount, Client client) {
        Transaction result = null;
        switch (type) {
            case CREDITING:
                result = new Crediting(amount, client);
                TransactionItemList.addTransactionItem(result);
                result.setCondition(TransactionCondition.STARTED);
                return result;
            case HUF_TRANSFER:
                result = new HufTransfer(amount, client);
                TransactionItemList.addTransactionItem(result);
                result.setCondition(TransactionCondition.STARTED);
                return result;
            default:
                return result;
        }
    }
}
