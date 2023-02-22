<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Spring MVC Form Handling</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
                    crossorigin="anonymous">
            </head>

            <body>
                <h1>User Registration Form</h1>
                <mvc:form modelAttribute="user" action="result">
                    <table>
                        <tr>
                            <td>First Name (*)</td>
                            <td>
                                <mvc:input path="name" required="true" placeholder="First Name" />
                            </td>
                        </tr>
                        <tr>
                            <td>Last Name (*)</td>
                            <td>
                                <mvc:input path="lastname" required="true" placeholder="Last Name" />
                            </td>
                        </tr>
                        <tr>
                            <td>Password (*)</td>
                            <td>
                                <mvc:password path="password" required="true" placeholder="Password" />
                            </td>
                        </tr>
                        <tr>
                            <td>Detail</td>
                            <td>
                                <mvc:textarea path="detail" placeholder="Detail information" />
                            </td>
                        </tr>
                        <tr>
                            <td>Birth Date</td>
                            <td>
                                <mvc:input path="birthDate" />
                            </td>
                        </tr>
                        <tr>
                            <td>Gender</td>
                            <td>
                                <mvc:radiobutton path="gender" items="${genders}" />
                            </td>
                        </tr>
                        <tr>
                            <td>Country</td>
                            <td>
                                <mvc:select path="country" items="${countries}" />
                            </td>
                        </tr>
                        <tr>
                            <td>Non Smoking</td>
                            <td>
                                <mvc:checkbox path="nonSmoking" checked="true" />
                            </td>
                        </tr>
                        <tr>
                            <td cols pan="2">
                                <input type="submit" value="Submit" />
                            </td>
                        </tr>
                    </table>
                    </mvc:form>

            </body>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
                crossorigin="anonymous"></script>

            </html>