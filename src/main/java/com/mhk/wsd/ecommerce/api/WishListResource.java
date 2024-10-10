package com.mhk.wsd.ecommerce.api;

import com.mhk.wsd.ecommerce.common.utils.AppUtils;
import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.domain.entity.WishList;
import com.mhk.wsd.ecommerce.service.ICustomerService;
import com.mhk.wsd.ecommerce.service.IWishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppUtils.WISH_LIST_URL)
@RequiredArgsConstructor
public class WishListResource {

    private final IWishListService wishListService;
    private final ICustomerService customerService;
    @GetMapping("/{customerUsername}")
    public List<WishList> getWishListByCustomerUsername(@PathVariable String customerUsername) {
        Customer customer = customerService.findByUsername(customerUsername);
        return wishListService.getWishListByCustomer(customer);
    }

}
