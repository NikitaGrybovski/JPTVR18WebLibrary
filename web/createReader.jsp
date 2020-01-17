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
            <label>Имя</label>
            <input type="text" name="nameofReader">
            <label>фамилия</label>
            <input type="text" name="surname">
            <label>День</label>
            <input type="number" name="day">
            <label>Месяц</label>
            <input type="number" name="month">
            <label>год</label>
            <input type="number" name="year">
            <label>Телефон</label>
            <input type="number" name="phone">
            <input type="submit" name="otpravit">
        </form>
    </body>
</html>
