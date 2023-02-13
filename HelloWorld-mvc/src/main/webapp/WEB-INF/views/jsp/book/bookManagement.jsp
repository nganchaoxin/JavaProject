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
<title>Book Management</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light text-center px-4">
  <a class="navbar-brand" href="book">Book Management</a>
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
          Add Book
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
            <td>${book.bookDetails.publishDate}</td>
            <td>${book.category.name}</td>
            <td>
              <button
                onclick="location.href='edit/${book.id}'"
                type="button"
                class="btn btn-secondary"
              >
                Edit
              </button>
            </td>
            <td>
              <button
                type="button"
                class="btn btn-danger"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
              >
                Delete
              </button>
            </td>
          </tr>
          <div
            class="modal fade"
            id="exampleModal"
            tabindex="-1"
            aria-labelledby="exampleModalLabel"
            aria-hidden="true"
          >
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">
                    Please confirm
                  </h1>
                  <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"
                  ></button>
                </div>
                <div class="modal-body">
                  Are you sure you want to delete this book?
                </div>
                <div class="modal-footer">
                  <button
                    type="button"
                    class="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Cancel
                  </button>
                  <button
                    onclick="location.href='delete/${book.id}'"
                    type="button"
                    class="btn btn-primary"
                  >
                    Yes!
                  </button>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </tbody>
    </c:if>
  </table>
</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</html>