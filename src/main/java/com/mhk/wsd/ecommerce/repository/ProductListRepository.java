package com.mhk.wsd.ecommerce.repository;

import com.mhk.wsd.ecommerce.domain.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Long> {
}
