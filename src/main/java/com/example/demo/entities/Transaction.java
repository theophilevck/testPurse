package com.example.demo.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table("transaction")
public class Transaction {

    @Id
    @Column("id")
    private Long id;

    @Column("amount")
    private float amount;

    @Column("payment_type")
    private PaymentTypeEnum paymentType;

    @Column("status")
    private StatusEnum status;

    @Transient
    private List<OrderLine> orders;

}
