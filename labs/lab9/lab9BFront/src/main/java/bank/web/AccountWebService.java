package bank.web;

import bank.dtos.AccountDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class AccountWebService {
    RestTemplate restTemplate = new RestTemplate();
    String serverUrl = "http://localhost:8080/account";

    public AccountDto createAccount(long accountnumber, String customerName) {
        return restTemplate.postForObject(serverUrl + "?accountnumber=" + accountnumber + "&customerName=" + customerName, null, AccountDto.class);
    }

    public void deposit(long accountnumber, double amount) {
        restTemplate.postForObject(serverUrl + "/deposit?accountnumber=" + accountnumber + "&amount=" + amount, null, Void.class);
    }

    public void depositEuros(long accountnumber, double amount) {
        restTemplate.postForObject(serverUrl + "/deposit-euros?accountnumber=" + accountnumber + "&amount=" + amount, null, Void.class);
    }

    public void transferFunds(long fromAccount, long toAccount, double amount, String description) {
        restTemplate.postForObject(serverUrl + "/transfer?fromAccount=" + fromAccount + "&toAccount=" + toAccount + "&amount=" + amount + "&description=" + description, null, Void.class);
    }

    public AccountDto getAccount(long accountnumber) {
        return restTemplate.getForObject(serverUrl + "/" + accountnumber, AccountDto.class);
    }

    public void withdraw(long accountnumber, double amount) {
        restTemplate.postForObject(serverUrl + "/withdraw?accountnumber=" + accountnumber + "&amount=" + amount, null, Void.class);
    }

    public List<AccountDto> getAllAccounts() {
        return restTemplate.getForObject(serverUrl, List.class);
    }

    public void withdrawEuros(long accountnumber, double amount) {
        restTemplate.postForObject(serverUrl + "/withdraw-euros?accountnumber=" + accountnumber + "&amount=" + amount, null, Void.class);
    }
}
