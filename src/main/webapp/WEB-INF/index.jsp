<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/4/22
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<html>
<head>
    <title>expenses</title>
</head>
<body>
<h1>All Expenses</h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Expense</th>
        <th scope="col">Vendor</th>
        <th scope="col">Amount</th>
        <th scope="col">Options</th>
    </tr>
    </thead>
    <tbody>
    <!-- loop over all the expenses to show the details as in the wireframe! -->
    <c:forEach items="${expenses}" var="expense">
        <tr>
            <td><a href="/expenses/${expense.id}"><c:out value="${expense.name}" /></a></td>
            <td><c:out value="${expense.vendor}" /></td>
            <td><c:out value="${expense.amount}" /></td>
            <td><a class="btn btn-warning" href="/expenses/${expense.id}/edit" >edit</a> </td>
            <td>
                <form action="/expenses/${expense.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete" class="btn btn-danger">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%--add form: to expose all form attributes to data binding--%>
<form:form action="/expense" method="POST" modelAttribute="expense">
    <div class="form-group">
        <form:label path="name">Expense Name</form:label>
        <form:input path="name" />
        <div><form:errors path="name" class="text-danger" /></div>
    </div>
    <div class="form-group">
        <form:label path="vendor">Vendor name</form:label>
        <form:input path="vendor" />
        <div><form:errors path="vendor" class="text-danger" /></div>
    </div>
    <div class="form-group">
        <form:label path="description">Expense description</form:label>
        <form:input type="text" path="description" />
        <div><form:errors path="description" class="text-danger" /></div>
    </div>
    <div class="form-group">
        <form:label path="amount">Expense amount</form:label>
        <form:input type="text" path="amount" />
        <div><form:errors path="amount" class="text-danger" /></div>
    </div>
    <input type="submit" value="Submit" class="btn btn-dark" />
</form:form>
</body>
</html>

