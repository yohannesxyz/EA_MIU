package bank.repositories;


import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface TraceRecordRepository extends JpaRepository<TraceRecord, Long> {
	@Transactional(propagation=Propagation.REQUIRES_NEW)
    public default void storeTraceRecord(TraceRecord traceRecord) {
		this.save(traceRecord);
    	
    }

}




