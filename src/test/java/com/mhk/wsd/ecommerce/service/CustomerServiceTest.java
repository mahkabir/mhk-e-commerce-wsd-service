package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.domain.entity.Customer;
import com.mhk.wsd.ecommerce.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
        customer.setUsername("testuser");
    }

    @Test
    public void testFindByUsername_Success() {
        // Mock the repository method
        when(customerRepository.findByUsername("testuser")).thenReturn(Optional.of(customer));

        // Call the service method
        Customer foundCustomer = customerService.findByUsername("testuser");

        // Assert the result
        assertNotNull(foundCustomer);
        assertEquals("testuser", foundCustomer.getUsername());

        // Verify the repository method was called
        verify(customerRepository, times(1)).findByUsername("testuser");
    }

    @Test
    public void testFindByUsername_NotFound() {
        // Mock the repository method
        when(customerRepository.findByUsername("nonexistentuser")).thenReturn(Optional.empty());

        // Call the service method and assert the exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            customerService.findByUsername("nonexistentuser");
        });

        assertEquals("Customer not found", exception.getMessage());

        // Verify the repository method was called
        verify(customerRepository, times(1)).findByUsername("nonexistentuser");
    }
}
