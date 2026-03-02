package it.unibo.pps.e1;

public class BronzeBankAccount extends BaseBankAccount {

    public BronzeBankAccount(CoreBankAccount base) {
        super(base);
    }

    @Override
    protected int applyFee(int amount){
        return amount < 100 ? 0 : 1;
    }

    @Override
    protected boolean checkIfWithdrawIsPossible(int withdraw) {
        return this.getBalance() < withdraw;
    }


}
