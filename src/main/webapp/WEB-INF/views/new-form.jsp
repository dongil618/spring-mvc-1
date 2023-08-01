<%--
  Created by IntelliJ IDEA.
  User: do_ng_iill
  Date: 2023/07/31
  Time: 10:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--상대경로 사용, [현재 URL이 속한 계층 경로 + /save] ex) /servlet-mvc/members/new-form에서 전송버튼 클릭시 URL : /servlet-mvc/members/save --%>
<%--보통은 절대경로로 사용함.--%>
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>

