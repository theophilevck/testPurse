package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("order_line")
public class OrderLine {

    @Id
    @Column("id")
    private Long id;

    @Column("product_name")
    private String productName;

    @Column("product_reference")
    private String productReference;

    @Column("quantity")
    private int quantity;

    @Column("price")
    private BigDecimal price;
}
