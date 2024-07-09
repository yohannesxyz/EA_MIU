package bank.service;

import bank.domain.Customer;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDTO(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        return customer;
    }
    public static CustomerDto getCustomerDTOFromCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        return customerDto;
    }
}
