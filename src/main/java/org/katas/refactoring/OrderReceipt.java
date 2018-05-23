package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
	private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append("======Printing Orders======\n");

		buildOrderInfoOfReceipt(output);

		double totSalesTx = 0d;
		double tot = 0d;
		for (OrderItem orderItem : order.getLineItems()) {
			buildOrderItemInfoOfReceipt(output, orderItem);

		}

        for (OrderItem orderItem : order.getLineItems()) {
            double salesTax = orderItem.totalAmount() * .10;
            totSalesTx += salesTax;
        }

        for (OrderItem orderItem : order.getLineItems()) {
            tot += orderItem.totalAmount();
        }
        tot += totSalesTx;

            // prints the state tax
		output.append("Sales Tax").append('\t').append(totSalesTx);

        // print total amount
		output.append("Total Amount").append('\t').append(tot);
		return output.toString();
	}

	private void buildOrderItemInfoOfReceipt(StringBuilder output, OrderItem orderItem) {
		output.append(orderItem.getDescription());
		output.append('\t');
		output.append(orderItem.getPrice());
		output.append('\t');
		output.append(orderItem.getQuantity());
		output.append('\t');
		output.append(orderItem.totalAmount());
		output.append('\n');
	}

	private void buildOrderInfoOfReceipt(StringBuilder output) {
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
	}
}