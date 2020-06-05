<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <p>Choose what you want to do:</p><br/>
    <!--<a href="customer/showForm">Add New Customer</a><br/>-->
   <%
       response.sendRedirect("customer/listCustomer");
   %>
    <!-- <a href="customer/updateCustomerForm">Update Customer</a> -->
</head>
<body>

</body>
</html>