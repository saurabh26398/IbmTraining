<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <title>Save Task</title>

    <link type="text/css"
          rel="stylesheet"
          href="../../../resources/static/css/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="../../../resources/static/css/css/add-task-style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Task Manager Home</h2>
    </div>
</div>

<div id="container">
    <h3>Save Task</h3>

    <form:form action="saveTask" modelAttribute="task" method="POST">
        <form:hidden path="id" />
        <div class="form-group">
            <label>Task Name:</label>
            <form:input path="taskName"/>

        </div>
        <br/>
        <div class="form-group">
            <label>Start Date:</label>
            <form:input path="startDate"/>

        </div>
        <br/>
        <div class="form-group">
            <label>End Date:</label>
            <form:input path="endDate"/>

        </div>
        <br/>
        <div class="form-group">
            <label>Task Status:</label>
            <form:input path="taskStatus"/>

        </div>
        <br/>

        <input type="submit" value="Save" class="save"/>
    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/task/listTask">Back to List</a>
    </p>

</div>

</body>

</html>








