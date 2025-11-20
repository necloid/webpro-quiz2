<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">Tasks</h1>

<a href="<c:url value='/tasks/create' />" class="bg-green-600 text-white px-4 py-2 rounded mb-4 inline-block">+ Add Task</a>

<table class="w-full bg-white shadow p-4 mt-3">
    <tr class="border-b">
        <th>Title</th>
<th>Status</th>
<th>Priority</th>
<th>Due</th>
<th>Category</th>
<th>Project</th>
<th>Actions</th>

<c:forEach var="t" items="${tasks}">
<tr>
    <td>${t.title}</td>
    <td>${t.status}</td>
    <td>${t.priority}</td>
    <td>${t.dueDate}</td>
    <td>${t.categoryName}</td>
    <td>${t.projectName}</td>
    <td>
        <a href="<c:url value='/tasks/edit?id=${t.id}' />">Edit</a>
        <a href="<c:url value='/tasks/delete?id=${t.id}' />"
           onclick="return confirm('Delete this task?');">Delete</a>
    </td>
</tr>
</c:forEach>
</table>

<jsp:include page="../includes/footer.jsp" />
