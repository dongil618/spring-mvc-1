package com.springmvc1.springmvc1.basic.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 무넺 고려되지 않음
 * 실무에서는 ConcurrentHashMAP, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }
    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

//    public List<Member> findAll() {
//        List<Member> memberList = new ArrayList<Member>();
//        store.entrySet().stream()
//                .forEach(e -> memberList.add(e.getValue()));
//        return memberList;
//    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store 자체를 보호하기 위해 이렇게 코드 작성
    }

    public void clearStore() {
        store.clear();
    }
}
