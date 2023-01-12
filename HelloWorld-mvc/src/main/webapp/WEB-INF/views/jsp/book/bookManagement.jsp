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
<title>hello</title>
</head>

<body>

</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
  <a class="navbar-brand" href="#">Book Management</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>


    </ul>
    <form:form action="search" method="get" class="form-inline my-2 my-lg-0" >
      <input name="searchInput" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form:form>
  </div>
</nav>



<div class="container">
<table class="table">
   <c:if test="${not empty bookList}">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Author</th>
      <th scope="col">ISBN</th>
      <th scope="col">Price</th>
      <th scope="col">Publish Date</th>
      <th scope="col">Category</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="book" items="${bookList}" varStatus="index">

        <tr>
              <th scope="row">${book.id}</th>
              <td>${book.name}</td>
              <td>${book.author}</td>
              <td>${book.bookDetails.isbn}</td>
              <td>${book.bookDetails.price}</td>
              <td>${book.bookDetails.publicDate}</td>
              <td>${book.category.name}</td>
              <td><button type="button" class="btn btn-primary btn-sm">Edit</button></td>
              <td><button type="button" class="btn btn-secondary btn-sm">Delete</button></td>
        </tr>

    </c:forEach>


  </tbody>
  </c:if>
</table>

</body>
</html>