package bank.repository;

import bank.integration.event.AccountChangeEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceRecordRepository extends JpaRepository<AccountChangeEvent,Long> {
}
