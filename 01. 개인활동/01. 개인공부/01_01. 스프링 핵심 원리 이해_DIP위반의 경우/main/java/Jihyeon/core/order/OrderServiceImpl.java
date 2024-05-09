package Jihyeon.core.order;

import Jihyeon.core.discount.DiscountPolicy;
import Jihyeon.core.discount.FixDiscountPolicy;
import Jihyeon.core.discount.RateDiscountPolicy;
import Jihyeon.core.member.Member;
import Jihyeon.core.member.MemberRepository;
import Jihyeon.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); 고정할인 정책일 경우
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  //할인정책 변동(%)
                  //추상에도 의존하고                      구체 클래스도 의존해버림 → DIP위반! (추상만 의존해야 함)

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //할인 정책이 변경되면 할인만 바꾸면 됨. 주문정책 수정이 필요없는 잘 된 코드
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
