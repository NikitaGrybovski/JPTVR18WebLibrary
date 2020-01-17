<%-- 
    Document   : giveBook
    Created on : Jan 17, 2020, 9:33:47 AM
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
    
        <form action="giveBook" method="POST">
            <h2>Книга: </h2>
            <select name="chooseBook">
            <c:forEach var="book" items="${listBook}">
                <option value="${book.id}">${book}</option>
            </c:forEach>
            </select>       
            <h2>Читатель: </h2>
            <select name="chooseReader">       
            <c:forEach var="reader" items="${listReader}">
                <option value="${reader.id}">${reader}</option>
            </c:forEach>       
            </select>
            
            <br><br><input type="submit">
            
            
        </form>
   
    </body>
</html>
