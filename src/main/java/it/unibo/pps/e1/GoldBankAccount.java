package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private CoreBankAccount base;

    public GoldBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return this.base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int overdraftLimit = -500;
        if ((this.getBalance()-amount)>overdraftLimit){
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
