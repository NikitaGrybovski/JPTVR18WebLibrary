<%-- 
    Document   : showLogin
    Created on : Jan 24, 2020, 9:13:07 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auth</title>
    </head>
    <body>
        <h1>Введите логин и пароль</h1>
        <form action="login" method="POST">
            <label>Логин</label><br><input type="text" name="login">
            <label>Пароль</label><br><input type="password" name="password">
            <input type="submit" value="Войти">
        </form>
    </body>
</html>
