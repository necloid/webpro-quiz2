<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">Projects</h1>
<a href="<c:url value='/projects/create'/>" class="bg-green-600 text-white px-4 py-2 rounded">+ Add Project</a>

<table class="w-full bg-white shadow mt-4">
    <tr><th>Name</th><th>Deadline</th><th>Actions</th></tr>
    <c:forEach var="p" items="${projects}">
        <tr>
            <td>${p.name}</td>
            <td>${p.deadline}</td>
            <td>
                <a href="<c:url value='/projects/edit?id=${p.id}' />">Edit</a>
                <a href="<c:url value='/projects/delete?id=${p.id}' />"
                onclick="return confirm('Delete project?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../includes/footer.jsp" />
