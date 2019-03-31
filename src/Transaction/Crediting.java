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
class Crediting extends Transaction {

    private final double rateOfCostCrediting = 0.03;
    private final double rateOfDutyCrediting = 0.003;

    public Crediting(int amount) {
        super(amount);
        this.rateOfCost = rateOfCostCrediting;
        this.rateOfDuty = rateOfDutyCrediting;
        this.cost = setCost();
        this.duty = setDuty();
    }

    @Override
    public void transaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Crediting " + super.toString();
    }

}
