<%-- 
    Document   : product
    Created on : Feb 4, 2023, 1:32:27 PM
    Author     : KHOA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">Cart</h1>

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>

<c:url value="/admin/products" var="action"/>
<form:form method="post" action="${action}" modelAttribute="product"
           enctype="multipart/form-data">
    <div class="form-group">
        <label for="file">ID</label>
        <form:input type="text" id="id" path="productID" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Name of product</label>
        <form:input type="text" id="name" path="name" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Price of product</label>
        <form:input type="text" id="price" path="price" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <label for="file">Image of product</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Add product" class="btn btn-danger"/>
    </div>
</form:form>