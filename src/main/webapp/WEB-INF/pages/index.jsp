<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task manager</title>
</head>
<body>
<div>
    <h1>Task manager</h1>
    <c:if test = "${!empty task}">
        <table class ="task-list-table">
            <tr>
                <th>Name</th>
                <th>Genre</th>
                <sec:authorize access="hasRole('admin')">
                    <th>&nbsp;</th>
                </sec:authorize>

            </tr>
            <c:forEach items = "${task}" var = "tasks">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.priority}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
