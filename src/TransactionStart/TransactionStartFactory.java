/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionStart;

import BankAccount.BankAccount;
import Transaction.Transaction;
import Transaction.TransactionCondition;
import Transaction.TransactionType;
import Util.Util;

/**
 *
 * @author FZs
 */
public class TransactionStartFactory {

    StringBuilder sb;

    public void getTransactionValid(BankAccount bankAccount, Transaction transaction) {
        sb = new StringBuilder();
        sb.append("Tranzakcióban érintett számla adatai:")
                .append(System.lineSeparator())
                .append("  ")
                .append(bankAccount.toString())
                .append(System.lineSeparator())
                .append("Indított tranzakció: ")
                .append(System.lineSeparator())
                .append("  ")
                .append(transaction.toString())
                .append(System.lineSeparator());
        if (clientIsValid(bankAccount, transaction)) {
            sb.append("Tranzakciót indító személy valid");
            if (transaction.getType() == TransactionType.HUF_TRANSFER && !ballanceTest(bankAccount, transaction)) {
                sb.append("Nincs fedezet!");
            } else {
                makeTransaction(bankAccount, transaction);
                transaction.setCondition(TransactionCondition.READY);
            }
        } else {
            transaction.setCondition(TransactionCondition.FAILD);
            sb.append("Baj van, Tranzakciót indító személy NEM valid!!")
                    .append(System.lineSeparator());
        }
        sb.append(transaction.getCondition().toString())
                .append(System.lineSeparator());
        System.out.println(sb);
    }

    private boolean clientIsValid(BankAccount bankAccount, Transaction transaction) {
        return Util.isExistingClient(bankAccount.getOwnerList(), transaction.getClient());
    }    

    private boolean ballanceTest(BankAccount bankAccount, Transaction transaction) {
        return bankAccount.getBallance() >= transaction.getAllDeduction();
    }

    private void makeTransaction(BankAccount bankAccount, Transaction transaction) {
        sb.append(System.lineSeparator())
                .append("Régi állapot: ")
                .append(bankAccount.toString())
                .append(System.lineSeparator());
        switch (transaction.getType()) {

            case CREDITING:
                bankAccount.setBallance(bankAccount.getBallance()
                        - transaction.getAllDeduction() + transaction.getAmount());
                sb.append("Új állapot: ")
                        .append(bankAccount.toString())
                        .append(System.lineSeparator());
                break;
            case HUF_TRANSFER:
                bankAccount.setBallance(bankAccount.getBallance()
                        - transaction.getAllDeduction() - transaction.getAmount());
                sb.append("Új állapot: ")
                        .append(bankAccount.toString())
                        .append(System.lineSeparator());
                break;
        }
    }

}
