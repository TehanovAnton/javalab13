<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.05.2021
  Time: 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <label>Вход в систему</label>
    <form name="login" method="post" action="controller?command=login" style="margin: 5px 5px 5px 0px;">
        <input name="loginName" type="text" content="loginName" style="margin: 5px;"><br>
        <input name="password" type="text" content="password" style="margin: 5px;"><br>

        <input type="submit" value="войти" style="margin: 5px;">
    </form>
    <form name="register" method="post" action="controller?command=registration_page">
        <input type="submit" value="регистрация">
    </form>

</body>
</html>
