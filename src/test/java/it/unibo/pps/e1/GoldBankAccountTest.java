package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BaseBankAccountTest{

    @BeforeEach
    void init(){this.account = new GoldBankAccount(new CoreBankAccount());}

    @ParameterizedTest
    @CsvSource({
            "1000, 200",
            "1000, 1500",
            "1000, 1200"
    })
    public void testCanWithdraw(int initialBalance,int withdrawAmount) {
        this.account.deposit(initialBalance);
        this.account.withdraw(withdrawAmount);
        assertEquals(initialBalance-withdrawAmount, this.account.getBalance());
    }


    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        int initialBalance = 1000;
        int withdrawAmount = 1600;
        this.account.deposit(initialBalance);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

}
