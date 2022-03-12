<%--
  Created by IntelliJ IDEA.
  User: 86178
  Date: 2022/3/12
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form method="post" action="login">
    用户名:<input type="text" name="username"><br>
    密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="text" name="password"><br>
    <div><%=session.getAttribute("error")==null?"":session.getAttribute("error")%></div>
    <button>登录</button>
  </form>
  </body>
</html>
