package com.mhk.wsd.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "sale_data")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductList product;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "sale_date", nullable = false)
    private Date saleDate;
}
