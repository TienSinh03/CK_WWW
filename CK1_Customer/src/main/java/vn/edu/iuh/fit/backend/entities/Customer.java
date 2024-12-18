/**
 * @ (#) Customer.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Table(name = "customer")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer implements java.io.Serializable{
    @Id
    @Column(name="cust_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="cust_name")
    private String name;

    @Column(name="cust_address")
    private String address;

    @Column(name="cust_email")
    private String email;

    @Column(name="cust_dob")
    private LocalDate dob;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Account> accounts;

}
