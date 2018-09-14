package com.cy.java8demo.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author congyang.guo
 */
public class TradeSort {
    public static void main(String[] args) {

        // 按币种分类 Currency
        List<Trade> trades = new ArrayList<Trade>();
        trades.add(new Trade(200, "HKD"));
        trades.add(new Trade(12, "HKD"));
        trades.add(new Trade(202, "HKD"));
        trades.add(new Trade(203, "USD"));
        trades.add(new Trade(207, "RMB"));
        trades.add(new Trade(2017, "RMB"));
        trades.add(new Trade(2027, "RMB"));


        // 普通写法
        Map<String, List<Trade>> tradeCurrency = new HashMap<>(16);
        for (Trade trade : trades) {
            if (trade.getPrice() > 100) {
                String currency = trade.getCurrency();
                List<Trade> tradesForCurrency = tradeCurrency.get(currency);
                if (tradesForCurrency == null) {
                    tradesForCurrency = new ArrayList<>();
                    tradeCurrency.put(currency, tradesForCurrency);
                }
                tradesForCurrency.add(trade);
            }
        }
        System.out.println(tradeCurrency);

        // lambda写法
        Map<String, List<Trade>> tradeCurrency2 = trades.stream().filter(trade -> trade.getPrice() > 100)
                .collect(Collectors.groupingBy(Trade::getCurrency));
        System.out.println(tradeCurrency2);
    }

}

class Trade {
    private int price;
    private String currency;

    public Trade(int price, String currency) {
        this.price = price;
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Trade{" + "price=" + price + ", currency='" + currency + '\'' + '}';
    }
}