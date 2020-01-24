<%-- 
    Document   : createReader
    Created on : Jan 17, 2020, 8:50:30 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Создание книги</h1>
        
        
        <form method="POST" action="createReader">
            <label>Имя</label><br>
            <input type="text" name="nameofReader"><br>
            <label>фамилия</label><br>
            <input type="text" name="surname"><br>
            <label>День</label><br>
            <input type="number" name="day"><br>
            <label>Месяц</label><br>
            <input type="number" name="month"><br>
            <label>год</label><br>
            <input type="number" name="year"><br>
            <label>Телефон</label><br>
            <input type="number" name="phone"><br>
            <label>логин</label><br>
            <input type="text" name="login" value="${login}"><br>
            <label>пароль</label><br>
            <input type="password" name="password"><br>
            
            
            <input type="submit" name="otpravit">
        </form>
    </body>
</html>
