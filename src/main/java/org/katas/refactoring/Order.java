package org.katas.refactoring;

import java.util.List;

public class Order {
    String nm;
    String addr;
    List<OrderItem> li;

    public Order(String nm, String addr, List<OrderItem> li) {
        this.nm = nm;
        this.addr = addr;
        this.li = li;
    }

    public String getCustomerName() {
        return nm;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<OrderItem> getLineItems() {
        return li;
    }
}
