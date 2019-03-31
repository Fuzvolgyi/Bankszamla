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
class HufTransfer extends Transaction {

    private final double rateOfCostHufTransfer = 0;
    private final double rateOfDutyHufTransfer = 0.003;
    private final TransactionType TYPE = TransactionType.HUF_TRANSFER;

    public HufTransfer(int amount) {
        super(amount);
        this.rateOfCost = rateOfCostHufTransfer;
        this.rateOfDuty = rateOfDutyHufTransfer;
        this.cost = setCost();
        this.duty = setDuty();
        this.type = TYPE;
    }

    @Override
    public void transaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "HufTransfer" + super.toString();
    }

}
