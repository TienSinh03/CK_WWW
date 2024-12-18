/**
 * @ (#) CustomerRepository.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.backend.entities.Customer;

import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT c FROM Customer c WHERE YEAR(c.dob) = 2000")
    public List<Customer> findCustomerByYearDob();
}
