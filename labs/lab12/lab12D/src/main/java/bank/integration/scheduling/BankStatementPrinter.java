package bank.integration.scheduling;

import bank.service.AccountDto;
import bank.service.AccountEntryDto;
import bank.service.CustomerDto;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class BankStatementPrinter {
    @Autowired
    private IAccountService accountService;

    @Scheduled(fixedRate=20000)
    public void print() {
        System.out.println("Printing bank statement");
        Collection<AccountDto> accountlist = accountService.getAllAccounts();
        CustomerDto customer ;
        for (AccountDto account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println(
                    "-Date-------------------------" + "-Description------------------" + "-Amount-------------");
            for (AccountEntryDto entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
                        entry.getAmount());
            }
            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }
}
