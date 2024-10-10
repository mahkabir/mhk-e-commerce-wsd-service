package com.mhk.wsd.ecommerce.service;

import com.mhk.wsd.ecommerce.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private static final Logger logger = LogManager.getLogger(SalesService.class);

    private final SalesRepository salesRepository;

    public Long getTotalSaleAmountForToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startOfDay = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date endOfDay = calendar.getTime();

        return salesRepository.findTotalSaleAmountForDay(startOfDay, endOfDay);
    }

    public Map<String, Object> getMaxSaleDayWithinRange(Date startDate, Date endDate) {
        Object[] result = salesRepository.findMaxSaleDayWithinRange(startDate, endDate);
        if (result != null && result.length > 0) {
            Map<String, Object> response = new HashMap<>();
            response.put("saleDate", result[0]);
            response.put("totalSale", result[1]);
            return response;
        }
        return null;
    }

    public List<Object[]> getTopFiveSellingItems() {
        return salesRepository.findTopFiveSellingItems().stream().limit(5).collect(Collectors.toList());
    }
    public List<Object[]> getTopFiveSellingItemsLastMonth() {
        logger.info("Getting top 5 selling items for the last month.");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, -1);
        Date startDate = calendar.getTime();

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date endDate = calendar.getTime();

        List<Object[]> topSellingItems = salesRepository.findTopFiveSellingItemsLastMonth(startDate, endDate).stream().limit(5).collect(Collectors.toList());

        logger.debug("Top 5 selling items for the last month: {}", topSellingItems);

        return topSellingItems;
    }

}
