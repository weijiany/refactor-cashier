package cc.xpbootcamp.warmup.cashier;

import java.util.stream.Collectors;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 *
 */
public class OrderReceipt {
    private final double TAX_RATE = .10;

    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        double totSalesTx = order.getTotalSalesTax(TAX_RATE);
        double tot = order.getTotalAmount() + totSalesTx;

        return getHeader() +
                getLineItemDetail() +
                getFooter(totSalesTx, tot);
    }

    private String getLineItemDetail() {
        return order.getLineItems().stream()
                .map(LineItem::getDetail)
                .collect(Collectors.joining());
    }

    private String getFooter(double totSalesTx, double tot) {
        return "Sales Tax" + '\t' + totSalesTx +
                "Total Amount" + '\t' + tot;
    }

    private String getHeader() {
        return "======Printing Orders======\n" +
                order.getCustomerName() +
                order.getCustomerAddress();
    }
}