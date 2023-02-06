<%-- 
    Document   : cart
    Created on : Feb 4, 2023, 10:52:16 AM
    Author     : KHOA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-center text-danger">Cart</h1>

<form:form method="post" action="" modelAttribute="product"
           enctype="multipart/form-data">
    <div class="form-group">
        <label for="file">Image of product</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Add product" class="btn btn-danger"/>
    </div>
</form:form>