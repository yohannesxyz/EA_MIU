package bank.dao;


import bank.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAccountDAO extends MongoRepository<Account, Long> {

}
