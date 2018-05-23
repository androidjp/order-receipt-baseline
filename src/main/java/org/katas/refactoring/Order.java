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

    void buildReceipt(StringBuilder output, OrderReceipt orderReceipt) {
        output.append(getCustomerName());
        output.append(getCustomerAddress());

        for (OrderItem orderItem : getOrderItemList()) {
            output.append(orderItem.getDescription());
            output.append('\t');
            output.append(orderItem.getPrice());
            output.append('\t');
            output.append(orderItem.getQuantity());
            output.append('\t');
            output.append(orderItem.totalAmount());
            output.append('\n');
        }
        double totalSalesTax = calculateTotalSalesTax();
        double totalPrice = calculateTotalPrice(totalSalesTax);

        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalPrice);
    }

    private double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (OrderItem orderItem : getOrderItemList()) {
            double salesTax = orderItem.totalAmount() * .10;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    private double calculateTotalPrice(double totalSalesTax) {
        double totalPrice = 0d;
        for (OrderItem orderItem : getOrderItemList()) {
            totalPrice += orderItem.totalAmount();
        }
        totalPrice += totalSalesTax;
        return totalPrice;
    }
}
