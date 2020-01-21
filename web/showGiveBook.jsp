<%-- 
    Document   : giveBook
    Created on : Jan 17, 2020, 9:33:47 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выдать книгу</title>
    </head>
    <body>
        
        <h1>Выдать книгу: </h1>
        <form action="createHistory" method="POST">
            <h2>Книга: </h2>
            <select name="chooseBook">
                
            <c:forEach var="book" items="${listBooks}">
                <option value="${book.id}">${book.name}. ${book.author}. ${book.publishedYear}</option>
            </c:forEach>
            </select>   
            
            <h2>Читатель: </h2>
            <select name="chooseReader">       
            <c:forEach var="reader" items="${listReaders}">
                <option value="${reader.id}">${reader.name}. ${reader.surname}. ${reader.phone}</option>
            </c:forEach>       
            </select>
            
            <br><br><input type="submit">
            
            
        </form>
   
    </body>
</html>
