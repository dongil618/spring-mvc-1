<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-07-28
  Time: 오후 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.springmvc1.springmvc1.domain.MemberRepository" %>
<%@ page import="com.springmvc1.springmvc1.domain.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  // request, response 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();
  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));
  Member member = new Member(username, age);
  System.out.println("member = " + member);
  memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id=<%=member.getId()%></li>
  <li>username=<%=member.getUsername()%></li>
  <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
