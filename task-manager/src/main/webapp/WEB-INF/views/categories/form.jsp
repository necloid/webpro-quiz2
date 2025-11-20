<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">
    <c:if test="${empty category}">Create Category</c:if>
    <c:if test="${not empty category}">Edit Category</c:if>
</h1>

<form method="post" action="<c:url value='/categories/create' />">
    <input type="hidden" name="id" value="${category.id}" />
    <label>Name:</label>
    <input type="text" name="name" value="${category.name}" required />
    <label>Color (hex):</label>
    <input type="text" name="color" value="${category.color}" />
    <button class="bg-blue-600 text-white px-4 py-2 rounded">Save</button>
</form>

<jsp:include page="../includes/footer.jsp" />
