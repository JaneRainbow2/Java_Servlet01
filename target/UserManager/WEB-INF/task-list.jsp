<%@ page import="com.softserve.itacademy.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Show all Tasks</title>
</head>
<body>
<%@include file="header.html"%>
<br>
<h2>List of Tasks</h2>
<table border="1">
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Priority</th>
        <th colspan="3">Operations</th>
    </tr>

    <%
        for (Task task : (List<Task>) request.getAttribute("tasks")) {
    %>
    <tr>
        <td><%=task.getId()%>
        </td>
        <td><%=task.getTaskName()%>
        </td>
        <td><%=task.getPriority()%>
        </td>
        <td>
            <a href="/read-task?id=<%=task.getId()%>">Read</a>
        </td>
        <td>
            <a href="/edit-task?id=<%=task.getId()%>">Edit</a>
        </td>
        <td>
            <a href="/tasks-delete?id=<%=task.getId()%>">Delete</a>
        </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
