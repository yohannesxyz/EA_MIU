package bank.dao;


import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountDAO extends JpaRepository<Account, Long> {

}
