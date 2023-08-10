package com.springmvc1.springmvc1.web.springmvc.v2;

import com.springmvc1.springmvc1.domain.Member;
import com.springmvc1.springmvc1.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v2")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/members") // members까지 없애주려면 클래스 레벨의 @RequestMapping부분을 "/springmvc/v2/members"라고 변경해주고 해당 메서드 레벨의 @RequestMapping에는 아무것도 넣어주지 않음! => @RequestMapping("/members") -> @RequestMapping으로 변경
    public ModelAndView getMembers (HttpServletRequest request, HttpServletResponse response) {
        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }

    @RequestMapping("/members/new-form")
    public ModelAndView newForm () {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/members/save")
    public ModelAndView saveMember (HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;
    }
}
