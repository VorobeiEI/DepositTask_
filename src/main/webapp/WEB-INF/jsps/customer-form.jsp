<%--
  Created by IntelliJ IDEA.
  User: JackSparrow
  Date: 5/11/2017
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Customer</title>

    <link type = "text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type = "text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>CRM-Customer Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Customer</h3>

    <form:form action="saveCustomer" modelAttribute="customer" method="POST">

        <!--need to associate this data with customer id -->

        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td>
                    <label>PlayerId:</label>
                </td>
                <td>
                    <form:input path="playerId"/>
                </td>
            </tr>
            <tr>
            <td>
                <label>Sum of Deposit:</label>
            </td>
            <td>
                <form:input path="sumOfDeposit"/>
            </td>
            </tr>
            <tr>
            <td>
                <label></label>
            </td>
            <td>
                <input type="submit" value="Save" class="save"/>
            </td>
            </tr>
            </tbody>
        </table>

    </form:form>

    <div style="clear: both;">  </div>
    <p>
        <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
    </p>
</div>
</body>
</html>
