package bank.dtos;

import bank.domain.Account;
import bank.domain.AccountEntry;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter {


    public static AccountDto getAccountDTOFromAccount(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountnumber(account.getAccountnumber());
        accountDto.setBalance(account.getBalance());
        accountDto.setCustomer(CustomerAdapter.getCustomerDTOFromCustomer(account.getCustomer()));
        for (AccountEntry accountEntry : account.getEntryList()){
            accountDto.getEntryList().add(AccountEntryAdapter.getAccountEntryDTOFromAccountEntry(accountEntry));
        }
        return accountDto;
    }

    public static Account getAccountFromAccountDto(AccountDto accountDto){
        Account account = new Account();
        account.setAccountnumber(accountDto.getAccountnumber());
        account.setCustomer(CustomerAdapter.getCustomerFromCustomerDTO(accountDto.getCustomer()));
        for (AccountEntryDto accountEntryDto : accountDto.getEntryList()){
            account.getEntryList().add(AccountEntryAdapter.getAccountEntryFromAccountEntryDTO(accountEntryDto));
        }
        return account;
    }

    public static List<AccountDto> getAccountDTOListFromAccountList(List<Account> accountList){
        List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
        for (Account account : accountList){
            accountDtoList.add(getAccountDTOFromAccount(account));
        }
        return accountDtoList;
    }
}
