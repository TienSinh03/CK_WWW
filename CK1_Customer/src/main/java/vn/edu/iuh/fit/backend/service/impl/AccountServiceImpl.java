/**
 * @ (#) AccountServiceImpl.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.entities.Account;
import vn.edu.iuh.fit.backend.repository.AccountRepository;
import vn.edu.iuh.fit.backend.service.AccountService;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> getAccountsBetweenBalance(double min, double max) {
        return accountRepository.getAccountsBetweenBalance(min, max);
    }
}
