/**
 * @ (#) CustomerServiceImpl.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Customer;
import vn.edu.iuh.fit.backend.repository.CustomerRepository;
import vn.edu.iuh.fit.backend.service.CustomerService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> getCustomersByYearDob() {
        return customerRepository.findCustomerByYearDob();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }
}
