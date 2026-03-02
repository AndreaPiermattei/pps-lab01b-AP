package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount{

    private CoreBankAccount base;

    public BronzeBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.base.deposit(amount);
    }

    private int applyFee(int amount){
        return amount < 100 ? 0 : 1;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + applyFee(amount));
    }
}
