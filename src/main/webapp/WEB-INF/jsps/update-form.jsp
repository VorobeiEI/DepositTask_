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
    <title>Save Deposit</title>

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
        <h2>Players` Deposit Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Sum of Deposit for Player</h3>

    <form:form action="saveDeposit" modelAttribute="player" method="POST">

        <!--need to associate this data with customer id -->

        <form:hidden path="id"/>

        <table>
            <tbody>
            <tr>
                <td>
                    <label>PlayerId:</label>
                </td>
                <td>
                    <form:input type="number" path="playerId"/>
                </td>
            </tr>
            <tr>
            <td>
                <label>Sum of Deposit:</label>
            </td>
            <td>
                <form:input type="number" path="deposit"/>
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
        <a href="${pageContext.request.contextPath}/deposit/list">Back to list</a>
    </p>
</div>
</body>
</html>
