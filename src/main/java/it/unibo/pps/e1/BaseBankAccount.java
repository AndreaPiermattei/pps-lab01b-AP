package it.unibo.pps.e1;

public abstract class BaseBankAccount implements BankAccount {
    protected CoreBankAccount base;

    public BaseBankAccount(CoreBankAccount base) {
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

    protected abstract int applyFee(int amount);

    @Override
    public abstract void withdraw(int amount);
}
