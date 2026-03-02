package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private CoreBankAccount base;

    public SilverBankAccount(CoreBankAccount base) {
        this.base = base;
    }

    private int applyFee(){
        return 1;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        base.withdraw(amount + applyFee());
    }
}
