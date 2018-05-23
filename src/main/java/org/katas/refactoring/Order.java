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

    public String buildReceipt() {
        StringBuilder receiptContent = new StringBuilder();
        receiptContent.append(getCustomerName());
        receiptContent.append(getCustomerAddress());

        for (OrderItem orderItem : getOrderItemList()) {
            receiptContent.append(orderItem.getDescription());
            receiptContent.append('\t');
            receiptContent.append(orderItem.getPrice());
            receiptContent.append('\t');
            receiptContent.append(orderItem.getQuantity());
            receiptContent.append('\t');
            receiptContent.append(orderItem.totalAmount());
            receiptContent.append('\n');
        }
        double totalSalesTax = calculateTotalSalesTax();
        double totalPrice = calculateTotalPrice(totalSalesTax);

        receiptContent.append("Sales Tax").append('\t').append(totalSalesTax);
        receiptContent.append("Total Amount").append('\t').append(totalPrice);

        return receiptContent.toString();
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
