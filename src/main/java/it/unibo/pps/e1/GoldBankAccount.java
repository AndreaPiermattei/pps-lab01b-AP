package it.unibo.pps.e1;

public class GoldBankAccount extends BaseBankAccount{

    public GoldBankAccount(CoreBankAccount base) {
        super(base);
    }

    @Override
    protected int applyFee(int amount) {
        return 0;
    }

    @Override
    protected boolean checkIfWithdrawIsPossible(int withdraw) {
        int overdraftLimit = -500;
        return (this.getBalance() - withdraw)<overdraftLimit;
    }
}
