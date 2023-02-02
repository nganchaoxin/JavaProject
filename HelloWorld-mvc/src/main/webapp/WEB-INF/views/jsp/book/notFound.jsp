<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8" %>
<%@ taglib prefix="c"uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />">
    <title>Book Not Found</title>
  </head>
  <body>
    <div
      class="container"
      style="margin-top: 20px; display: flex; justify-content: center"
    >
      <div class="modal-dialog modal-confirm">
        <div class="modal-content">
          <div class="modal-header flex-column">
            <div class="icon-box">
              <i class="fal fa-times">&#129409;</i>
            </div>
            <h4 class="modal-title w-50">Book Not Found</h4>
          </div>
          <div class="modal-body">
            <p style="font-size: 110%">
              This Book ID: ${id} is not exist! Please choose another!
            </p>
          </div>
          <div class="modal-footer justify-content-center">
            <button
              type="button"
              class="btn btn-primary"
              onclick="location.href='./book'"
            >
              Back to Book
            </button>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</html>
