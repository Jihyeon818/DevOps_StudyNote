package Jihyeon.core.order;

public interface OrderService {
    Order creatOrder(Long memberId, String itemName, int itemPrice);
}
