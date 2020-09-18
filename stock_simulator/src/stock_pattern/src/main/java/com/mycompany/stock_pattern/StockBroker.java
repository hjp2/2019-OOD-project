
package com.mycompany.stock_pattern;

import java.util.Map;
/**
 * Observer interface
 */
interface StockBroker {
    void update(Map<String, Double> stockList);
}