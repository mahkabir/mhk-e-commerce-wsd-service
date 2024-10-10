package com.mhk.wsd.ecommerce.repository;

import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.domain.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findByCustomer(Customer customer);
}
