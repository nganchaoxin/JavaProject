<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>">
    <title>Products to buy</title>
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
      <a class="navbar-brand" href="./">Home</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">My Cart</a>
          </li>
        </ul>
      </div>
    </nav>
    <div class="container">
      <h3>Please fill information</h3>
      <br />
      <form:form method="POST" modelAttribute="orders" action="resultOrders">
        <div class="form-group">
          <label for="exampleInputEmail1">Customer Name (*)</label>
          <form:input type="text" path="customerName" class="form-control col-md-6" />
        </div>
        <div class="form-group">
          <label for="exampleInputEmail1">Customer Address (*)</label>
          <form:input type="text" path="customerAddress" class="form-control col-md-6" required="true" />
        </div>
        <div class="form-group visually-hidden" >
          <label for="exampleInputEmail1">Order Date</label>
          <form:input type="text" path="orderDate" class="form-control col-md-6" required="true" />
        </div>
        <br/>
        <div class="form-group">
          <button type="submit" class="btn btn-primary col-md-2">
            Continue
          </button>
        </div>
      </form:form>
    </div>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>
