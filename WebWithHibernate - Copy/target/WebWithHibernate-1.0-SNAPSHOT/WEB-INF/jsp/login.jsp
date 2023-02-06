<%-- 
    Document   : login
    Created on : Feb 5, 2023, 10:03:12 AM
    Author     : KHOA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Login page</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        There is error when login
    </div>
</c:if>

<c:url value="/login" var="action"/>

<form method="post" action="${action}">
    <div class="form-group">
        <label for="userID">UserID</label>
        <input type="text" id="userID" name="userID" class="form-control"/>
        <label for="password">Password</label>
        <input type="text" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Sign In" class="btn btn-danger"/>
    </div>
</form>
