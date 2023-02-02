<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Upload File Request Page</title>
    <link rel="stylesheet" href="/resources/css/dropzone.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />">
</head>
<body>
    <div class="container" style="margin-top: 60px;">
        <div class="col-md-6">
            <h2>Upload a file...</h2>
            <form:form action="uploadFile" method="POST" enctype="multipart/form-data" cssClass="dropzone" id="my-awesome-dropzone">
                <div class="input-group">
                    <input type="file" name="file" class="form-control" id="" />
                </div>
                <br>
                <button type="submit" class="btn btn-info">Upload</button>
            </form:form>
        </div>
    </div>

</body>

</html>