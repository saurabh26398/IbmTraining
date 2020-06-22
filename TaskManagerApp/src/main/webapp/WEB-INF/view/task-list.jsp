<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>

<html>

<head>
    <link rel="stylesheet" href="webjars/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <title>List Tasks</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="../../../resources/static/css/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Task Manager Home</h2>
    </div>
</div>
    <input type="button" onclick="window.location.href='showFormForAdd'; return false"
    class="add-button" value="Add New Task">
<br/><br/>
<div id="container">
    <div id="content">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Task Name</th>
                <th scope="col">Start Date</th>
                <th scope="col">End Date</th>
                <th scope="col">Task Status</th>

            </tr>

            <c:forEach var="tempTask" items="${tasks}">
            <c:url var="updateLink" value="/task/showFormForUpdate">
                <c:param name="taskId" value="${tempTask.id}" />
            </c:url>
            <c:url var="deleteLink" value="/task/delete">
                <c:param name="taskId" value="${tempTask.id}" />
            </c:url>
            <tr>
                <td> ${tempTask.taskName} </td>
                <td> ${tempTask.startDate} </td>
                <td> ${tempTask.endDate} </td>
                <td> ${tempTask.taskStatus}</td>


                <td>
                    <a href="${updateLink}">Update</a>
                    <a href="${deleteLink}">Delete</a>
                </td>

            </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>







