package com.mhk.wsd.ecommerce.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "product_list")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "initial_amount")
    private Long initialAmount;
    @Column(name = "price")
    private Long price;
}
