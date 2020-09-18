
package com.mycompany.stock_pattern;
import java.util.Iterator;
import java.util.Map;

public class StockViewer implements StockBroker {
    public void update(Map<String, Double> stocks) {
        System.out.println("StockViewer: stockList is changed:");
        stocks.forEach((symbol, value) -> System.out.println(symbol + " - $" + value));
    }
}