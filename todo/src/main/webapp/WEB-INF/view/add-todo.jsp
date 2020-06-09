<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <style>
        .error {color: #ff0000

        }
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
    <title>Save Todo</title>

    <link type="text/css"
          rel="stylesheet"
          href="css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="css/add-todo-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Todo Manager</h2>
    </div>
</div>

<ul class="nav">
    <li>Home</li>
    <li>Todos</li>

</ul>
<div id="container">
    <h3>Save Todo</h3>


    <%--@elvariable id="todo" type=""--%>
    <form:form action="processForm" modelAttribute="todo" method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label>Description:</label>
            <form:input type="text" path="description"/>
            <form:errors path="description" cssClass="error" />

        </div>
        <br/>
        <div class="form-group">
            <label>Target Date:</label>
            <form:input type="date" path="date"/>
            <form:errors path="date" cssClass="error" />

        </div>
        <br/>

        <input type="submit" value="SaveTodo" class="save"/>
    </form:form>


</div>

</body>

</html>
