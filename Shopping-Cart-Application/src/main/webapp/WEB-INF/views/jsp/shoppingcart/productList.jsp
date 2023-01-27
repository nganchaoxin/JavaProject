<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>">
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>">
<title>Products to buy</title>
</head>

<body>

</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
  <a class="navbar-brand" href="./">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="./myCart">My Cart</span></a>
      </li>
    </ul>
  </div>
</nav>

<div class="container">
<table class="table">
   <c:if test="${not empty productList}">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Description</th>
      <th scope="col">Unit Price</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="product" items="${productList}" varStatus="index">
        <tr>
              <th scope="row">${product.id}</th>
              <td>${product.name}</td>
              <td>${product.productDescription}</td>
              <td>${product.price}</td>
              <td><button onclick="location.href='addToCart/${product.id}'" type="button" class="btn btn-secondary">Add to cart</button></td>
        </tr>
    </c:forEach>

  </tbody>
  </c:if>
</table>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>