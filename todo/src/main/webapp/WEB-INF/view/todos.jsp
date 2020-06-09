<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>List Todos</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="css/style.css" />
<style>
    .nav {
        background-color: yellow;
        list-style-type: none;
        text-align: center;
        margin: 0;
        padding: 0;
    }

    .nav li {
        display: inline-block;
        font-size: 20px;
        padding: 20px;
    }
</style>
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Todo manager</h2>
    </div>
</div>
<ul class="nav">
    <li>Home</li>
    <li>Todos</li>

</ul>
<button onclick="window.location.href='showForm'">Add Todo</button>
<div id="content">
    <table class="table table-dark">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Description</th>
            <th scope="col">Target Date</th>

        </tr>

        <c:forEach var="tempTodo" items="${todos}">
        <c:url var="updateLink" value="/todo/showFormForUpdate">
            <c:param name="id" value="${tempTodo.id}" />
        </c:url>
        <c:url var="deleteLink" value="/todo/delete">
            <c:param name="id" value="${tempTodo.id}" />
        </c:url>


        <tr>
            <td> ${tempTodo.description} </td>
            <td> ${tempTodo.date} </td>

            <td> <a href="${updateLink}">Update</a> </td>
            <td> <a href="${deleteLink}">Delete</a> </td>
        </tr>

        </c:forEach>

    </table>

</div>

</div>


</body>

</html>







