package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.domain.entity.Customer;

public interface ICustomerService {

    Customer findByUsername(String username);
}
