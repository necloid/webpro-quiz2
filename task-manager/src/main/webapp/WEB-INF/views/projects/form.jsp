<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">
    <c:if test="${empty project}">Create Project</c:if>
    <c:if test="${not empty project}">Edit Project</c:if>
</h1>

<form method="post" action="<c:url value='/projects/create' />">
    <input type="hidden" name="id" value="${project.id}" />
    <label>Name:</label>
    <input type="text" name="name" value="${project.name}" required />
    <label>Deadline:</label>
    <input type="date" name="deadline" value="${project.deadline}" />
    <button class="bg-blue-600 text-white px-4 py-2 rounded">Save</button>
</form>

<jsp:include page="../includes/footer.jsp" />
