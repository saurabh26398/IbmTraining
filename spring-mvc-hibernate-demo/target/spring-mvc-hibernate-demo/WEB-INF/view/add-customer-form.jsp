<%--
  Created by IntelliJ IDEA.
  User: Saurabh Jangid
  Date: 6/4/2020
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">

    First name: <form:input path="firstName" />
    <br><br>
    Last name (*): <form:input path="lastName" />
    <br><br>
    Email: <form:input path="email" />
    <input type="submit" value="submit">

</form:form>

</body>
</html>
