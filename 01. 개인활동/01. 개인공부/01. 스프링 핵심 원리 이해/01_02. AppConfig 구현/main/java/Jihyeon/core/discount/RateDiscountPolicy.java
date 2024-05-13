package Jihyeon.core.discount;

import Jihyeon.core.member.Grade;
import Jihyeon.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discontPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price * discontPercent / 100;
        }else {
            return 0;
        }
    }
}
