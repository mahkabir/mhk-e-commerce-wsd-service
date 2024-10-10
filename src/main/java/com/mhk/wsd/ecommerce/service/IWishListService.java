package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.domain.entity.WishList;

import java.util.List;

public interface IWishListService {
    List<WishList> getWishListByCustomer(Customer customer);
}
