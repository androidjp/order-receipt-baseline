package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        buildCustomerInfoOfReceipt(output);
        buildOrderItemListInfoOfReceipt(output);
        buildTotalPriceAndTaxOfReceipt(output);
        return output.toString();
    }

    private void buildTotalPriceAndTaxOfReceipt(StringBuilder output) {
        double totalSalesTax = calculateTotalSalesTax();
        double totalPrice = calculateTotalPrice(totalSalesTax);

        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalPrice);
    }

    private double calculateTotalPrice(double totalSalesTax) {
        double totalPrice = 0d;
        for (OrderItem orderItem : order.getOrderItemList()) {
            totalPrice += orderItem.totalAmount();
        }
        totalPrice += totalSalesTax;
        return totalPrice;
    }

    private double calculateTotalSalesTax() {
        double totalSalesTax = 0d;
        for (OrderItem orderItem : order.getOrderItemList()) {
            double salesTax = orderItem.totalAmount() * .10;
            totalSalesTax += salesTax;
        }
        return totalSalesTax;
    }

    private void buildOrderItemListInfoOfReceipt(StringBuilder output) {
        for (OrderItem orderItem : order.getOrderItemList()) {
            output.append(orderItem.getDescription());
            output.append('\t');
            output.append(orderItem.getPrice());
            output.append('\t');
            output.append(orderItem.getQuantity());
            output.append('\t');
            output.append(orderItem.totalAmount());
            output.append('\n');
        }
    }

    private void buildCustomerInfoOfReceipt(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}