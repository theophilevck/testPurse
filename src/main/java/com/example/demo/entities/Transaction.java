package com.example.demo.entities;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {


    @Id
    @Column("id")
    private Long id;

    private BigDecimal amount;

    @Column("payment_type")
    private PaymentTypeEnum paymentType;

    @Column("status")
    private StatusEnum status;

    private List<OrderLine> orders;


}
