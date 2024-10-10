package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.domain.entity.WishList;
import com.mhk.wsd.ecommerce.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    public List<WishList> getWishListByCustomer(Customer customer) {
        return wishListRepository.findByCustomer(customer);
    }
}
