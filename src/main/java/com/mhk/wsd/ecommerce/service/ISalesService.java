package com.mhk.wsd.ecommerce.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
public interface ISalesService {

    Long getTotalSaleAmountForToday();
    Map<String, Object> getMaxSaleDayWithinRange(Date startDate, Date endDate);
    List<Object[]> getTopFiveSellingItems();
    List<Object[]> getTopFiveSellingItemsLastMonth();

}
