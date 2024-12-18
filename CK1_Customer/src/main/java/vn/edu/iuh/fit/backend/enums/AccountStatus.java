/**
 * @ (#) AccountStatus.java      12/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.enums;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/18/2024
 */
public enum AccountStatus {
    CHECKING("CHECKING"), CHECKED("CHECKED");

    private final String value;

    AccountStatus(String value) {
        this.value = value;
    }
}
