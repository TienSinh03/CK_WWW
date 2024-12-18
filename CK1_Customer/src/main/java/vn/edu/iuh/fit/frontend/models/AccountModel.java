/**
 * @ (#) AccountModel.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import vn.edu.iuh.fit.backend.entities.Account;
import vn.edu.iuh.fit.backend.entities.Customer;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Component
public class AccountModel {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/";

    public List<Account> getAccountsBetweenBalance(double min, double max) {
        return restTemplate.getForObject(URL+"accounts/between_balance?min="
                +min+
                "&max="+max, List.class);
    }

    public Customer getAccountById(Long id) {
        return restTemplate.getForObject(URL+"customers/"+id, Customer.class);
    }

    public List<Customer> getCustomersByYear() {
        return restTemplate.getForObject(URL +"customers/by_year_dob" ,List.class);
    }

    public List<Customer> getCustomers() {
        return restTemplate.getForObject(URL +"customers" ,List.class);
    }
}
