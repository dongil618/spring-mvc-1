package com.springmvc1.springmvc1.web.frontcontroller.v4.controller;

import com.springmvc1.springmvc1.domain.Member;
import com.springmvc1.springmvc1.domain.MemberRepository;
import com.springmvc1.springmvc1.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관함.
        model.put("member", member);
        return "save-result";
    }
}
