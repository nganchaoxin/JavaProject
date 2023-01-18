<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <nav class="navbar navbar-expand-lg navbar-light bg-light text-center">
                    <a class="navbar-brand" href="book">Book Management</a>

                </nav>
                <div class="container">
                    <h1 align="center">Add a new book</h1>
                    <form:form action="${action}" modelAttribute="book" method="post">
                        <legend class="scheduler-border"><c:out value="${msg}"/></legend>
                        <c:if test="${type.equals('update')}">
                            <div class="form-group">
                                <label class="form-group">ID</label>
                                <form:input path="id" type="text" class="form-group" id="id" placeholder="Id"
                                    disabled="true" />
                                <form:hidden path="id" />
                                <form:hidden path="bookDetails.id"/>
                            </div>
                        </c:if>
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Name(*)</label>
                            <form:input path="name" type="text" class="form-control" id="exampleInputEmail1"
                                aria-describedby="emailHelp" required="true" placeholder="Name" />

                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Author(*)</label>
                            <form:input path="author" type="text" required="true" placeholder="Author"
                                class="form-control" id="exampleInputPassword1" />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">ISBN(*)</label>
                            <form:input path="bookDetails.isbn" type="text" required="true" placeholder="ISBN"
                                class="form-control" id="exampleInputPassword1" />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Price(*)</label>
                            <form:input path="bookDetails.price" type="number" required="true" placeholder="Price"
                                min="1" class="form-control" id="exampleInputPassword1" />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Publish Date(*)</label>
                            <form:input path="bookDetails.publishDate" type="date" required="true"
                                placeholder="Publish Date" class="form-control" id="exampleInputPassword1" />
                        </div>
                        <form:select path="category.id" class="form-control">
                            <form:option value="0" label="---Select---" />
                            <form:options items="${categoryList}" />
                        </form:select>

                        <button type="submit" class="btn btn-primary">Save</button>
                    </form:form>

                </div>

            </body>

            </html>