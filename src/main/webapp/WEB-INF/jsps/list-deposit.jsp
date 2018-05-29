
<%--
  Created by IntelliJ IDEA.
  User: JackSparrow
  Date: 5/3/2017
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Deposits</title>

    <!-- reference style sheet-->
    <link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>

<div id ="wrapper">
    <div id = "header">
        <h2>Players` Deposit Manager</h2>
    </div>
    <br>

    <div id = "container">
        <div id = "content">

            <!-- put Add Customer button -->

            <input type="button" value = "Add Deposit"
                   onclick="window.location.href='showFormForAdd';return false;"
                   class="add-button"
            />

            <!--add a search box-->
            <form:form action="search" method="post">
                Search players`s deposits: <input type="number" name="theSearchPlayerId"/>

                <input type="submit" value="Search" class="add-button"/>

            </form:form>


            <!-- add our table here-->

            <table>
                <tr>
                    <th>PlayerId</th>
                    <th>Date</th>
                    <th>Sum of Deposit</th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print our customers-->

                <c:forEach var = "tempPlayer" items = "${customers}">
                    <!-- construct an update link with customer id-->
                    <c:url var="updateLink" value="/deposit/showFormForUpdate">
                        <c:param name="customerId" value="${tempPlayer.id}"/>
                    </c:url>

                    <!-- construct an delete link with customer id-->
                    <c:url var="deleteLink" value="/deposit/delete">
                        <c:param name="customerId" value="${tempPlayer.id}"/>
                    </c:url>


                    <tr>
                        <td>${tempPlayer.playerId}</td>
                        <td>${tempPlayer.date}</td>
                        <td>${tempPlayer.deposit}</td>
                        <td><!--display the update link-->
                        <a href="${updateLink}">Update</a>
                            |
                        <a href="${deleteLink}" onclick="if(!(confirm('Are you sure' +
                         ' you want to delete thos deposit?'))) return false">Delete</a>
                        </td>

                    </tr>
                </c:forEach>
                <tr>
                    <th>Total:</th>
                    <th></th>
                    <th>${deposums}</th>
                    <th></th>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
