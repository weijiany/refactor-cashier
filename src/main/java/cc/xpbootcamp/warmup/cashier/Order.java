package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String cName;
    String addr;
    List<LineItem> lineItemList;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.cName = cName;
        this.addr = addr;
        this.lineItemList = lineItemList;
    }

    public String getCustomerName() {
        return cName;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }

    public double getTotalSalesTax(double taxRate) {
        return getTotalAmount()  * taxRate;
    }

    public double getTotalAmount() {
        return getLineItems().stream().map(LineItem::totalAmount).mapToDouble(Double::doubleValue).sum();
    }
}
