<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Task</title>
</head>
<body>
<%@include file="header.html"%>
<br>
<h2>Create new Task</h2>
<form action="/create-task" method="post">
    <table>
        <tr>
            <td>
                <label for="taskname">Name: </label>
            </td>
            <td>
                <input type="text" id="taskname" name="taskname">
            </td>
        </tr>
        <tr>
            <td>
                <label for="priority">Priority: </label>
            </td>
            <td>
                <select id="priority"  name="priority">
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="submit" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
