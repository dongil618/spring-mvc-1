package com.springmvc1.springmvc1.web.frontcontroller.v2.controller;

import com.springmvc1.springmvc1.domain.Member;
import com.springmvc1.springmvc1.domain.MemberRepository;
import com.springmvc1.springmvc1.web.frontcontroller.MyView;
import com.springmvc1.springmvc1.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        // Model에 데이터를 보관함.
        request.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }

}
