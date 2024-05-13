package Jihyeon.core;

import Jihyeon.core.discount.DiscountPolicy;
import Jihyeon.core.discount.FixDiscountPolicy;
import Jihyeon.core.discount.RateDiscountPolicy;
import Jihyeon.core.member.MemberService;
import Jihyeon.core.member.MemberServiceImpl;
import Jihyeon.core.member.MemoryMemberRepository;
import Jihyeon.core.order.OrderService;
import Jihyeon.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    private static MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
