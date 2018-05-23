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

    public String generateReceipt() {
        StringBuilder output = new StringBuilder();
        buildHeaderOfReceipt(output);
        order.buildReceipt(output, this);
        return output.toString();
    }

    private void buildHeaderOfReceipt(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }

}