package bank.integration.kafkaMessaging;


public class CustomerMessage {
    private long accountNumber;
    private String customerName;
    private double amount;


    public CustomerMessage() {
    }

    public CustomerMessage(long accountNumber, String customerName, double amount) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.amount = amount;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomerMessage [accountNumber=" + accountNumber + ", customerName=" + customerName + ", amount=" + amount + "]";
    }

}
