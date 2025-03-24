package agin.llc1.llc1.bridge;

public class OrderBridge {
    private Platform platform;
    private OrderType orderType;

    public OrderBridge(Platform platform, OrderType orderType) {
        this.platform = platform;
        this.orderType = orderType;
    }

    public void placeOrder(String orderDetails) {
        platform.placeOrderOnPlatform(orderDetails, orderType);
    }
}
