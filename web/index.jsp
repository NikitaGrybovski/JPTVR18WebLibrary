<%-- 
    Document   : index
    Created on : Jan 14, 2020, 9:39:05 AM
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
        <h1>Библиотека</h1>
        <h2>${info}</h2>
        <a href="showLogin">Вход</a><br>
        <a href="logout">Выход</a><br>
        <a href="createbook.jsp">Создание книги</a><br>
        <a href="showbook">Список книг</a><br>
        <a href="createReader.jsp">Создание пользователя</a><br>
        <a href="showReader">Список пользователей</a><br>
        <a href="showGiveBook">Выдать книгу</a><br>
        <a href="returnBookShow">Возврат книги</a>
</html>
