package customers;


@org.springframework.context.annotation.Configuration
public class Configuration {
    @org.springframework.context.annotation.Bean
    public ICustomerDAO customerDAO() {
        return new CustomerDAO(logger());
    }
    @org.springframework.context.annotation.Bean
    public IEmailSender emailSender() {
        return new EmailSender(logger());
    }
    @org.springframework.context.annotation.Bean
    public ILogger logger() {
        return new Logger();
    }
    @org.springframework.context.annotation.Bean
    public ICustomerService customerService() {
        CustomerService customerService = new CustomerService();
        customerService.setCustomerDAO(customerDAO());
        customerService.setEmailSender(emailSender());
        return customerService;
    }
}
