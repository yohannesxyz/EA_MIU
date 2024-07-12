package bank;

import bank.domain.Account;
import bank.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
public class AccountTest {
    Account account;
    @BeforeEach
    public void setUp() {
         account = new Account();
    }
    @Test
    public void testDeposit(){
        account.deposit(100.0);
        assertThat( account.getBalance(), closeTo (100.0, 0.01));
    }
    @Test
    public void testWithdraw(){
        account.deposit(100.0);
        account.withdraw(50.0);
        assertThat( account.getBalance(), closeTo (50.0, 0.01));
    }
    @Test
    public void testTransferFunds(){
        account.deposit(100.0);
        Customer customer = new Customer("John");
        Account toAccount = new Account();
        toAccount.setCustomer(customer);
        account.transferFunds(toAccount, 50.0, "transfer");
        assertThat(account.getBalance(),closeTo(50.0,0.01));
    }


}

