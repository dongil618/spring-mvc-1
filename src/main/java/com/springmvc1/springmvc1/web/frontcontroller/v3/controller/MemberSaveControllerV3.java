package com.springmvc1.springmvc1.web.frontcontroller.v3.controller;

import com.springmvc1.springmvc1.domain.Member;
import com.springmvc1.springmvc1.domain.MemberRepository;
import com.springmvc1.springmvc1.web.frontcontroller.ModelView;
import com.springmvc1.springmvc1.web.frontcontroller.MyView;
import com.springmvc1.springmvc1.web.frontcontroller.v2.ControllerV2;
import com.springmvc1.springmvc1.web.frontcontroller.v3.ControllerV3;
import org.springframework.boot.Banner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관함.
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
