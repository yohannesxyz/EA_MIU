package bank.integration.event;

import bank.repository.TraceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountChangeEventListner {

    @Autowired
    private TraceRecordRepository traceRecordRepository;

    @EventListener
    public void onEvent(AccountChangeEvent event) {
            switch (event.getDescription()) {
                case "deposit":
                  System.out.println("deposit event"+event.getAmount());
                    break;
                case "withdraw":
                    System.out.println("withdraw event"+event.getAmount());
                    break;
                case "transfer":
                    System.out.println("transfer event"+event.getAmount());
                    break;
                default:
                    System.out.println("Unknown event: " + event);
            }

            traceRecordRepository.save(event);

    }
}
