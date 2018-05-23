package org.katas.refactoring;

import java.util.List;

public class Order {
    String name;
    String address;
    List<OrderItem> orderItemList;

    public Order(String name, String address, List<OrderItem> orderItemList) {
        this.name = name;
        this.address = address;
        this.orderItemList = orderItemList;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
}
