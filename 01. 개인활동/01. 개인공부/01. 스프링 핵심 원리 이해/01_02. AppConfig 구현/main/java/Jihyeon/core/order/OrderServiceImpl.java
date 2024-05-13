package Jihyeon.core.order;

import Jihyeon.core.discount.DiscountPolicy;
import Jihyeon.core.discount.FixDiscountPolicy;
import Jihyeon.core.discount.RateDiscountPolicy;
import Jihyeon.core.member.Member;
import Jihyeon.core.member.MemberRepository;
import Jihyeon.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인 정책이 변경되면 할인만 바꾸면 됨. 주문정책 수정이 필요없는 잘 된 코드
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
