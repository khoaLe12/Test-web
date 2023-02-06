<%-- 
    Document   : hello
    Created on : Jan 31, 2023, 7:28:32 PM
    Author     : KHOA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

    <h2>List all user:</h2>
    <c:forEach var="item" items="${ALL}">
        <li>${item}</li>
    </c:forEach>

    <h2>List userId, fullName and password</h2>
    <c:forEach var="item" items="${ALL1}">
        <li>${item[0]} - ${item[1]} - ${item[2]}</li>
    </c:forEach>
        
    <h2>Search user by full name:</h2>
    <c:forEach var="person" items="${content}">
        <li>${person.userID} - ${person.fullName} - ${person.age}</li>
        </c:forEach>

    <h2>Statistical query:</h2>
    Count of users and Max age in the list of user's age:
    ${message[0]} users - age: ${message[1]}

    <h2>Statistical query using group by and order by:</h2>
    <c:forEach var="item" items="${MESSGAE}">
        <p>Full Name: ${item[0]} - Number of product: ${item[1]} - Max price: ${item[2]}</p>
    </c:forEach>
</body>
</html>
