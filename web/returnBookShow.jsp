<%-- 
    Document   : returnBookShow
    Created on : Jan 21, 2020, 10:53:56 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Возврат книги</h1>
        <form action="createReturnBook" method="POST">
            <select name="chooseHistory">
                
            <c:forEach var="history" items="${listHistory}">
                <option value="${history.id}">${history.giveOfDate}. ${history.book}. ${history.reader}</option>
            </c:forEach>
            </select>   
            <br><br>
            <input type="submit">
        </form>
    </body>
</html>
