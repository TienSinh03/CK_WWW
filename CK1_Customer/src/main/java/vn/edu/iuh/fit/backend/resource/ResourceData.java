/**
 * @ (#) ResourceData.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.entities.Account;
import vn.edu.iuh.fit.backend.entities.Customer;
import vn.edu.iuh.fit.backend.service.AccountService;
import vn.edu.iuh.fit.backend.service.CustomerService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@RestController
@RequestMapping("/api")
public class ResourceData {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @RequestMapping("/customers/by_year_dob")
    public ResponseEntity<List<Customer>> getCustomersByYear() {
        return ResponseEntity.ok(customerService.getCustomersByYearDob());
    }

    @RequestMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @RequestMapping("/accounts/between_balance")
    public ResponseEntity<List<Account>> getAccountsBetweenBalance(double min, double max) {
        return ResponseEntity.ok(accountService.getAccountsBetweenBalance(min, max));
    }


}
