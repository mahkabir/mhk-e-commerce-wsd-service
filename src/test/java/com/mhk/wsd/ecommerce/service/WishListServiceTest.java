package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.domain.entity.ProductList;
import com.mhk.wsd.ecommerce.domain.entity.WishList;
import com.mhk.wsd.ecommerce.repository.WishListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WishListServiceTest {

    @Mock
    private WishListRepository wishListRepository;

    @InjectMocks
    private WishListServiceImpl wishListService;

    private Customer customer;
    private List<WishList> wishLists;
    private ProductList product1;
    private ProductList product2;

    @BeforeEach
    void setUp() {
        customer = Customer.builder()
                .id(1L)
                .username("testuser")
                .email("testuser@example.com")
                .firstName("Test")
                .lastName("User")
                .build();

        product1 = ProductList.builder()
                .id(101L)
                .productName("Product 1")
                .build();

        product2 = ProductList.builder()
                .id(102L)
                .productName("Product 2")
                .build();

        WishList wishList1 = WishList.builder()
                .id(1L)
                .customer(customer)
                .product(product1)
                .build();

        WishList wishList2 = WishList.builder()
                .id(2L)
                .customer(customer)
                .product(product2)
                .build();

        wishLists = new ArrayList<>();
        wishLists.add(wishList1);
        wishLists.add(wishList2);
    }

    @Test
    public void testGetWishListByCustomer() {
        when(wishListRepository.findByCustomer(any(Customer.class))).thenReturn(wishLists);

        List<WishList> result = wishListService.getWishListByCustomer(customer);

        assertEquals(2, result.size());
        assertEquals(wishLists.get(0).getProduct().getProductName(), result.get(0).getProduct().getProductName());
        assertEquals(wishLists.get(1).getProduct().getProductName(), result.get(1).getProduct().getProductName());
    }
}
