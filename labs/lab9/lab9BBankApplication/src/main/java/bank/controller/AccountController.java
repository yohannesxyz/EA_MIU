package bank.controller;

import bank.service.AccountDto;
import bank.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestParam long accountnumber, @RequestParam String customerName) {
        AccountDto res = accountService.createAccount(accountnumber, customerName);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestParam long accountnumber, @RequestParam double amount) {
        accountService.deposit(accountnumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/deposit-euros")
    public ResponseEntity<?> depositEuros(@RequestParam long accountnumber, @RequestParam double amount) {
        accountService.depositEuros(accountnumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferFunds(@RequestParam long fromAccount, @RequestParam long toAccount, @RequestParam double amount, @RequestParam String description) {
        accountService.transferFunds(fromAccount, toAccount, amount, description);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllAccounts() {
        Collection<AccountDto> accountlist = accountService.getAllAccounts();
        return new ResponseEntity<>(accountlist, HttpStatus.OK);
    }

    @GetMapping("/{accountnumber}")
    public ResponseEntity<?> getAccount(@PathVariable long accountnumber) {
        AccountDto account = accountService.getAccount(accountnumber);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam long accountnumber, @RequestParam double amount) {
        accountService.withdraw(accountnumber, amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
