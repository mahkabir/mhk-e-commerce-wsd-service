package com.mhk.wsd.ecommerce.service;


import com.mhk.wsd.ecommerce.repository.SalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalesServiceTest {

    @Mock
    private SalesRepository salesRepository;

    @InjectMocks
    private SalesServiceImpl salesService;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testGetTotalSaleAmountForToday() {
        Long expectedTotalSaleAmount = 100L;

        when(salesRepository.findTotalSaleAmountForDay(any(Date.class), any(Date.class))).thenReturn(expectedTotalSaleAmount);

        Long totalSaleAmountForToday = salesService.getTotalSaleAmountForToday();

        assertEquals(expectedTotalSaleAmount, totalSaleAmountForToday);
    }

    @Test
    public void testGetMaxSaleDayWithinRange() {
        Date startDate = new Date();
        Date endDate = new Date();
        Object[] result = { new Date(), 200L };

        when(salesRepository.findMaxSaleDayWithinRange(startDate, endDate)).thenReturn(result);

        Map<String, Object> response = salesService.getMaxSaleDayWithinRange(startDate, endDate);

        assertEquals(result[0], response.get("saleDate"));
        assertEquals(result[1], response.get("totalSale"));
    }

    @Test
    public void testGetTopFiveSellingItems() {
        List<Object[]> topSellingItems = new ArrayList<>();
        topSellingItems.add(new Object[]{"Product1", 10});
        topSellingItems.add(new Object[]{"Product2", 8});

        when(salesRepository.findTopFiveSellingItems()).thenReturn(topSellingItems);

        List<Object[]> result = salesService.getTopFiveSellingItems();

        assertEquals(topSellingItems.size(), result.size());
        assertEquals(topSellingItems.get(0)[0], result.get(0)[0]);
        assertEquals(topSellingItems.get(0)[1], result.get(0)[1]);
    }

    @Test
    public void testGetTopFiveSellingItemsLastMonth() {
        List<Object[]> topSellingItems = new ArrayList<>();
        topSellingItems.add(new Object[]{"Product1", 10});
        topSellingItems.add(new Object[]{"Product2", 8});

        when(salesRepository.findTopFiveSellingItemsLastMonth(any(Date.class), any(Date.class))).thenReturn(topSellingItems);

        List<Object[]> result = salesService.getTopFiveSellingItemsLastMonth();

        assertEquals(topSellingItems.size(), result.size());
        assertEquals(topSellingItems.get(0)[0], result.get(0)[0]);
        assertEquals(topSellingItems.get(0)[1], result.get(0)[1]);
    }
}
