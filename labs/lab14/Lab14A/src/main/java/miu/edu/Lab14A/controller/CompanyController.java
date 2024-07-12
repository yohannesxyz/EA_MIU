package miu.edu.Lab14A.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
    @GetMapping("/shop")
    public ResponseEntity<?> getShop(){
        return new ResponseEntity<String>("this is the shop", HttpStatus.OK);
    }

    @GetMapping("/orders")
    @PreAuthorize("hasRole('employee')")
    public ResponseEntity<?> getOrders(){
        return new ResponseEntity<String>("this is Orders", HttpStatus.OK);
    }

    @GetMapping("/payments")
    @PreAuthorize("hasRole('employee') and hasRole('finance')")
    public ResponseEntity<?> getPayment(){
        return new ResponseEntity<String>("this is Orders", HttpStatus.OK);
    }
}

