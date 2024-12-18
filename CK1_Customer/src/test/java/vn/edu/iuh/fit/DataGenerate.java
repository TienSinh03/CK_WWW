/**
 * @ (#) DataGenerate.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.backend.entities.Account;
import vn.edu.iuh.fit.backend.entities.Customer;
import vn.edu.iuh.fit.backend.enums.AccountStatus;
import vn.edu.iuh.fit.backend.repository.AccountRepository;
import vn.edu.iuh.fit.backend.repository.CustomerRepository;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@SpringBootTest
public class DataGenerate {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void generatedCustomer() {
        Faker faker = new Faker();
        for (int i = 1; i <= 3; i++) {
            Customer customer = new Customer();
            customer.setName(faker.name().fullName());
            customer.setAddress(faker.address().fullAddress());
            customer.setEmail(faker.internet().emailAddress());
            customer.setDob(faker.date().birthdayLocalDate());

            customerRepository.save(customer);
        }
    }

    @Test
    public void generatedAccount() {
        Faker faker = new Faker();
        for (int i = 1; i <= 3; i++) {
            Customer customer = customerRepository.findById((long) i).get();
            for (int j = 1; j <= 3; j++) {
                Account account = new Account();
                account.setBalance(faker.number().randomDouble(2, 100, 1000));
                account.setCustomer(customer);
                account.setStatus(AccountStatus.CHECKING);
                accountRepository.save(account);
            }

        }
    }
}
