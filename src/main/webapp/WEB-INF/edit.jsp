<%--
  Created by IntelliJ IDEA.
  User: nisrinekane
  Date: 10/4/22
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
  <title>Edit expenses</title>
</head>
<body>
<h1>Edit Expense</h1>
<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense" class="form">
  <input type="hidden" name="_method" value="put">
  <p class="form-group">
    <form:label path="name">Name of Expense</form:label>
    <form:errors path="name"/>
    <form:input path="name"/>
  </p>
  <p class="form-group">
    <form:label path="vendor">Vendor</form:label>
    <form:errors path="vendor"/>
    <form:textarea path="vendor"/>
  </p>
  <p class="form-group">
    <form:label path="description">Description</form:label>
    <form:errors path="description"/>
    <form:input path="description"/>
  </p>
  <p class="form-group">
    <form:label path="amount">Amount</form:label>
    <form:errors path="amount"/>
    <form:input type="number" step="0.01" path="amount"/>
  </p>
  <input type="submit" value="Submit" class="btn btn-dark"/>
</form:form>
</body>
</html>

