package com.example.demo.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_line")
@Getter
@Setter
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_line_id_seq")
    @SequenceGenerator(name = "order_line_id_seq", sequenceName = "order_line_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    private String productName;

    private String productReference;

    private BigDecimal quantity;

    private BigDecimal price;

    @ManyToOne
    private Transaction transaction;
}
