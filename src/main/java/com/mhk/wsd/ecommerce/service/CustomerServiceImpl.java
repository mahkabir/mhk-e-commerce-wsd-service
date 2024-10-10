package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.common.exceptions.EcommerceWsdDomainException;
import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private final CustomerRepository customerRepository;
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username)
                .orElseThrow(() -> new EcommerceWsdDomainException("Customer not found"));
    }
}
