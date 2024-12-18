/**
 * @ (#) Account.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entities;

import jakarta.persistence.*;

import lombok.*;
import vn.edu.iuh.fit.backend.enums.AccountStatus;

import java.io.Serializable;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Table(name = "account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account implements Serializable {
    @Id
    @Column(name="acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="acc_number")
    private double balance;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

}
