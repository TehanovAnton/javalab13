<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 04.05.2021
  Time: 7:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <label>Регистрация</label>
    <form name="login" method="post" action="controller?command=register_new_user" style="margin: 5px 5px 5px 0px;">
        <input type="text" name="loginName" content="loginName" style="margin: 5px;"><br>
        <input type="text" name="password" content="Password" style="margin: 5px;"><br>
        <input type="submit" value="подтвердить" style="margin: 5px;">
    </form>
    <form name="back" method="post" action="controller?command=login_page">
        <input name="back" type="submit" value="вернуться">
    </form>
</body>
</html>
