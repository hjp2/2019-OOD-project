
package com.mycompany.stock_pattern;
import java.util.Iterator;
import java.util.Map;


public class StockBuyer implements StockBroker {
    public void update(Map<String, Double> stocks) {
        System.out.println("StockBuyer: stockList is changed:");
        stocks.forEach((symbol, value) -> System.out.println(symbol + " - $" + value));
    }
}
