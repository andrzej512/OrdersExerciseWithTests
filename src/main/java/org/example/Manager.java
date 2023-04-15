package org.example;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<Order, Integer> map;

    public Manager() {
        this.map = new HashMap<>();
    }

    public Map<Order, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Order, Integer> map) {
        this.map = map;
    }

    public void addOrderToMap(Order order) {
        this.map.put(order, this.map.containsKey(order) ? (this.map.get(order)) + 1 : 1);
    }

    public void removeOrderFromMap(Order order) {
        Integer orderValue = this.map.get(order).intValue();
        if (orderValue > 1) {
            this.map.put(order, orderValue - 1);
        } else {
            this.map.remove(order);
        }


    }
}
