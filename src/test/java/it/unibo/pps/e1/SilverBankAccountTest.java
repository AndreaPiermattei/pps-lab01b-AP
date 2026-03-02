package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BaseBankAccountTest{


    @BeforeEach
    void init(){this.account = new SilverBankAccount(new CoreBankAccount());}

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int deposit = 1000;
        this.account.deposit(deposit);
        assertEquals(deposit, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int initialBalance = 1000;
        int withdrawAmount = 200;
        this.account.deposit(initialBalance);
        this.account.withdraw(withdrawAmount);
        assertEquals(initialBalance-withdrawAmount-1, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int initialBalance = 1000;
        int withdrawAmount = 1100;
        this.account.deposit(initialBalance);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
