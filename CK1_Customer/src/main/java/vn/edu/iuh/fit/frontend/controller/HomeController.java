/**
 * @ (#) HomeController.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.frontend.models.AccountModel;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
@Controller
public class HomeController {

    @Autowired
    private AccountModel accountModel;

    @GetMapping({"","/", "/index"})
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", accountModel.getCustomers());
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String getCustomer(Model model, @PathVariable long id) {
        model.addAttribute("customer", accountModel.getAccountById(id));
        return "customers-details";
    }

    @GetMapping("/report2/customers/by_year_dob")
    public String getCustomersByYear(Model model) {
        model.addAttribute("customers", accountModel.getCustomersByYear());
        return "customers";
    }


    @GetMapping("/showReport1")
    public String showBlankReport(Model model) {
        return "accounts";
    }

    @GetMapping("/accounts/between_balance")
    public String getAccountsBetweenBalance(Model model, @RequestParam("min") double min, @RequestParam("max") double max) {
        model.addAttribute("accounts", accountModel.getAccountsBetweenBalance(min, max));
        return "accounts";
    }
}
