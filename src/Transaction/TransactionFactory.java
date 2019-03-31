/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

/**
 *
 * @author FZs
 */
public class TransactionFactory {

    public Transaction getTransaction(TransactionType type, int amount) {
        switch (type) {
            case CREDITING:
                return new Crediting(amount);
            case HUF_TRANSFER:
                return new HufTransfer(amount);
            default:
                return null;
        }
    }
}
