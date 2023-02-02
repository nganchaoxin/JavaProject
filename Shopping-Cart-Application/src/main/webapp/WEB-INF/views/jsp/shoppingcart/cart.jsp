<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="
    <c:url value="/resources/bootstrap/css/bootstrap.css" />
    "> <link rel="stylesheet" href="
    <c:url value="/resources/bootstrap/js/bootstrap.min.js" />
    ">
    <title>Products to buy</title>
  </head>
  <jsp:include page="header.jsp" />
  <body>
    <div class="container">
      <h3>My Shopping Cart</h3>
      <br />
      <table class="table">
        <c:if test="${empty cartList}">
          <p>No item in Cart</p>
        </c:if>
        <c:if test="${not empty cartList}">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Name</th>
              <th scope="col">Description</th>
              <th scope="col">Unit Price</th>
              <th scope="col">Quantity</th>
              <th scope="col"></th>
              <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="cart" items="${cartList}" varStatus="index">
              <tr>
                <th scope="row">${cart.product.id}</th>
                <td>${cart.product.name}</td>
                <td>${cart.product.productDescription}</td>
                <td>${cart.product.price}</td>
                <td>${cart.quantity}</td>
                <td>
                  <button
                    onclick="location.href='removeItem/${cart.product.id}'"
                    type="button"
                    class="btn btn-secondary"
                  >
                    Remove from cart
                  </button>
                </td>
              </tr>
            </c:forEach>
          </tbody>
          <div class="row justify-content-center">
              <button
                onclick="location.href='./checkOut'"
                type="button"
                class="btn btn-primary"
              >
                Check out
              </button>
           </div>
        </c:if>
      </table>

    </div>
  </body>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</html>
