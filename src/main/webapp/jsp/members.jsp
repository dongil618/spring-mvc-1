<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2023-07-28
  Time: 오후 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.springmvc1.springmvc1.domain.MemberRepository" %>
<%@ page import="com.springmvc1.springmvc1.domain.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
  </thead>
  <tbody>
    <% for(Member member : members) {%>
        <tr>
          <td><%= member.getId() %></td>
          <td><%= member.getUsername() %></td>
          <td><%= member.getAge() %></td>
        </tr>
    <% } %>
    <%-- 아래와 같이 해도 됨 --%>
    <%
      for (Member member : members) {
        out.write(" <tr>");
        out.write(" <td>" + member.getId() + "</td>");
        out.write(" <td>" + member.getUsername() + "</td>");
        out.write(" <td>" + member.getAge() + "</td>");
        out.write(" </tr>");
      }
    %>
  </tbody>
</table>
</body>
</html>
