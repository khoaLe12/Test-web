<%-- 
    Document   : index
    Created on : Jan 29, 2023, 10:06:22 AM
    Author     : KHOA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1 class="text-center text-danger">List of products in shop </h1>

<form action="">
    <div class="row">
        <div class="col-md-11">
            <input class="form-control" type="text" name="kw" placeholder="Input keyword"/>
        </div>
        <div class="col-md-1">
            <input type="submit" value="Search" class="btn btn-danger"/>
        </div>
    </div>
</form>
<div>
    <ul class="pagination">
        <c:forEach begin="1" end="${Math.ceil(counter/6)}" var="i">
            <li class="page-item"><a class="page-link" href="<c:url value="/" />?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</div>
<div class="row">
    <c:forEach var="product" items="${products}">
        <div class="card col-md-4">
            <div class="card-body">
                <c:if test="${product.image.startsWith('https') == true}">
                    <img class="img-fluid" src="<c:url value="${product.image}" />" alt="${product.name}"/>
                </c:if>
                <c:if test="${product.image == null || product.image.startsWith('https') == false}">
                    <img class="img-fluid" src="<c:url value="images/hhh.png" />" alt="${product.name}"/>
                </c:if>
            </div>
            <div class="card-footer bg-info">
                <h3>${product.name}</h3>
                <p>${product.price} VND</p>
            </div>
        </div>
    </c:forEach>
</div>

<p>Input 2 fullName of user you want to search (This is an OR condition)</p>
<c:url value="/hello" var="action1" />
<form method="POST" action="${action1}">
    Input name1: <input type="text" name="name1"/></br>
    Input name2: <input type="text" name="name2"/></br>
    <input type="submit" value="send"/>
</form>
