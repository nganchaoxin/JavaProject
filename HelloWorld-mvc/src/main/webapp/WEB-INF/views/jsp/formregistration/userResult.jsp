<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib   uri="http://www.springframework.org/tags/form" prefix="mvc" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC Form Handling</title>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </head>

    <body>
        <h1>User Registration Result</h1>

        <table>
            <tr>
                <td>Name</td>
                <td>${user.name}</td>
            </tr>

            <tr>
                <td>Last name</td>
                <td>${user.lastname}</td>
            </tr>

            <tr>
                <td>Password</td>
                <td>${user.password}</td>
            </tr>
            <tr>
                <td>Detail</td>
                <td>${user.detail}</td>
            </tr>
            <tr>
                <td>Birth Date</td>
                <td>${user.birthDate}</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>${user.gender}</td>
            </tr>
            <tr>
                <td>Non-Smoking</td>
                <td>${user.nonSmoking}</td>
            </tr>


        </table>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    </html>