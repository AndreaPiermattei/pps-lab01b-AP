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
    public void withdraw(int amount) {
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + applyFee(amount));
    }

}
