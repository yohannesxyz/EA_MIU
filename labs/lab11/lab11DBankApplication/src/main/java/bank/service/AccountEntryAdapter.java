package bank.service;

import bank.domain.AccountEntry;

public class AccountEntryAdapter {
    public static AccountEntry getAccountEntryFromAccountEntryDTO(AccountEntryDto accountEntryDto){
        AccountEntry accountEntry = new AccountEntry();
        accountEntry.setDate(accountEntryDto.getDate());
        accountEntry.setAmount(accountEntryDto.getAmount());
        accountEntry.setDescription(accountEntryDto.getDescription());
        accountEntry.setFromAccountNumber(accountEntryDto.getFromAccountNumber());
        accountEntry.setFromPersonName(accountEntryDto.getFromPersonName());
        return accountEntry;
    }
    public static AccountEntryDto getAccountEntryDTOFromAccountEntry(AccountEntry accountEntry){
        AccountEntryDto accountEntryDto = new AccountEntryDto();
        accountEntryDto.setDate(accountEntry.getDate());
        accountEntryDto.setAmount(accountEntry.getAmount());
        accountEntryDto.setDescription(accountEntry.getDescription());
        accountEntryDto.setFromAccountNumber(accountEntry.getFromAccountNumber());
        accountEntryDto.setFromPersonName(accountEntry.getFromPersonName());
        return accountEntryDto;
    }
}
