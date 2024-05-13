package Jihyeon.core.member;

import Jihyeon.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach //Test 실행 전 먼저 실행되어야 함
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService(); //먼저 실행되서 할당됨
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
