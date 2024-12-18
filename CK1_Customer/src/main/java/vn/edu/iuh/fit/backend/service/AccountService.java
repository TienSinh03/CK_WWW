/**
 * @ (#) AccountServiceImpl.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.service;

import vn.edu.iuh.fit.backend.entities.Account;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
public interface AccountService {
    List<Account> getAccountsBetweenBalance(double min, double max);
}
