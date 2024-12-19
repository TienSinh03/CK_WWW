/**
 * @ (#) PageDto.java      12/19/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.backend.dtos;

import lombok.*;

import java.util.Collection;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 12/19/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @ToString
public class PageDto <T> {
    private int page;
    private int size;
    private Collection<T> values;
    private int total;
    private int totalPages;

    private String sortBy;
    private String sortType = "ASC";
}
