<%-- 
    Document   : header
    Created on : Feb 2, 2023, 8:50:37 PM
    Author     : KHOA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Grey with black text -->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#">Trang chu</a>
        </li>
        <c:forEach var="user" items="${ALL}">
            <li class="nav-item">
                <a class="nav-link" href="#">${user.fullName}</a>
            </li>
        </c:forEach>
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/cart"/>">Cart</a>
        </li>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
              <li class="nav-item active">
                  <a class="nav-link text-danger" href="<c:url value="/login"/>">Log In</a>
              </li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
              <li class="nav-item active">
                  <a class="nav-link text-danger" href="<c:url value="/"/>">${pageContext.request.userPrincipal.name}</a>
              </li>
        </c:if>     
    </ul>
</nav>
