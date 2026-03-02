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
    public void withdraw(int amount) {
        int overdraftLimit = -500;
        if ((this.getBalance() - amount)<overdraftLimit) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + applyFee(amount));
    }
}
