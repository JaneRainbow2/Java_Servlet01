<%@ page import="com.softserve.itacademy.Task" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show info about Task</title>
</head>
<body>
<%@include file="header.html" %>
<br>
<h2>Read existing Task</h2>
<%
    Task task = (Task) request.getAttribute("task");
%>
<p>Id: &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<strong><%=task.getId()%>
</strong></p>

<p>Title: &nbsp; &nbsp; &nbsp;<strong><%=task.getTaskName()%>
</strong></p>

<p>Priority: <strong><%=task.getPriority()%>
</strong></p>

</body>
</html>
