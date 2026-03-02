package it.unibo.pps.e1;

public class SilverBankAccount extends BaseBankAccount {


    public SilverBankAccount(CoreBankAccount base) {
        super(base);
    }

    @Override
    protected int applyFee(int amount){
        return 1;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + applyFee(amount));
    }


}
