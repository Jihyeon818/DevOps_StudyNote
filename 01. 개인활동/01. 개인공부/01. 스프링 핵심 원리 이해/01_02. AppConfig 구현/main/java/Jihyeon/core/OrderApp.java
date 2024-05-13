package Jihyeon.core;

import Jihyeon.core.member.Grade;
import Jihyeon.core.member.Member;
import Jihyeon.core.member.MemberService;
import Jihyeon.core.member.MemberServiceImpl;
import Jihyeon.core.order.Order;
import Jihyeon.core.order.OrderService;
import Jihyeon.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creatOrder(memberId,"itemA",20000);

        System.out.println("주문정보 = " + order);
        System.out.println("할인된 금액 = " + order.calculatePrice());
    }
}
