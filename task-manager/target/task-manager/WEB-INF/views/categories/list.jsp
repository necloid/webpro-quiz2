<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">Categories</h1>
<a href="<c:url value='/categories/create'/>" class="bg-green-600 text-white px-4 py-2 rounded">+ Add Category</a>

<table class="w-full bg-white shadow mt-4">
    <tr><th>Name</th><th>Color</th><th>Actions</th></tr>
    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.name}</td>
            <td>${c.color}</td>
            <td>
                <a href="<c:url value='/categories/edit?id=${c.id}' />">Edit</a>
                <a href="<c:url value='/categories/delete?id=${c.id}' />"
                onclick="return confirm('Delete category?');">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../includes/footer.jsp" />