package com.springmvc1.springmvc1.domain;

import com.springmvc1.springmvc1.domain.Member;
import com.springmvc1.springmvc1.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("동일", 27);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
        // given
        String[] usernames = { "동일1", "동일2", "동일3"};

        Member member1 = new Member(usernames[0], 27);
        Member member2 = new Member(usernames[1], 28);
        Member member3 = new Member(usernames[2], 29);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result).contains(member1, member2, member3);

        // 아래는 내가 혼자 생각해낸 테스트 방식인데 위의 방식이 깔끔하고 정확한 것 같다!
        AtomicInteger index = new AtomicInteger();
        result
            .stream()
            .forEach(member -> Assertions.assertThat(member.getUsername()).isEqualTo(usernames[index.getAndIncrement()]));

        index.set(0);
        result
                .stream()
                .forEach(member -> System.out.println(usernames[index.getAndIncrement()]));
    }

    @Test
    void clearStore() {
    }
}