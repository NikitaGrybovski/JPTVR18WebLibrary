<%-- 
    Document   : createbook
    Created on : Jan 14, 2020, 10:42:36 AM
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
        <p>${info}</p>
        <a href="createBook">Создать</a>
        <form method="POST" action="createBook">
            <label>Название</label>
            <input type="text" name="name">
            <label>Автор</label>
            <input type="text" name="author">
            <label>Год выпуска</label>
            <input type="number" name="publishedYear">
            <label>ISBN</label>
            <input type="text" name="isbn">
            <input type="submit" name="otpravit">
        </form>
    </body>
</html>
