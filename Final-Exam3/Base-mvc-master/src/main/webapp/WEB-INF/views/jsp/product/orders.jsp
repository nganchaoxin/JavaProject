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
<title>Order Management</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light text-center px-4">
  <a class="navbar-brand" href="book">Order Management</a>
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
      <a href="newBook"
        ><button type="button" class="btn btn-primary mx-4">
          Add Order
        </button></a
      >
    </ul>
    <form:form action="search" method="get" class="form-inline my-2 my-lg-0">
       <div class="row">
            <div class="col ">
                <input
                    name="searchInput"
                    class="form-control mr-sm-2"
                    type="search"
                    placeholder="Search"
                    aria-label="Search"
                  />
            </div>
            <div class="col px-0 mx-0">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    Search
                  </button>
            </div>

       </div>

    </form:form>
  </div>
</nav>

<div class="container">
  <table class="table">
    <c:if test="${not empty ordersList}">
      <thead>
        <tr>
          <th scope="col">OrderID</th>
          <th scope="col">OrderDate</th>
          <th scope="col">Customer Name</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="order" items="${ordersList}" varStatus="index">
          <tr>
            <th scope="row">${order.orderId}</th>
            <td>${order.orderDate}</td>
            <td>${order.customerName}</td>

            <td>
              <button
                 onclick="location.href='showOrderDetailsList/${order.orderId}'"
                type="button"
                class="btn btn-secondary"
              >
                View Details
              </button>
            </td>

          </tr>

        </c:forEach>
      </tbody>
    </c:if>
  </table>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>