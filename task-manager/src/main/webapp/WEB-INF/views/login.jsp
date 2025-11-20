<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="includes/header.jsp" />

<div class="max-w-md mx-auto bg-white shadow p-6 rounded">
    <h1 class="text-xl font-bold mb-4">Login</h1>

    <c:if test="${not empty error}">
        <div class="bg-red-200 p-2 rounded mb-3 text-red-700">
            ${error}
        </div>
    </c:if>

    <form action="<c:url value='/login' />" method="post">
        <label class="block">Username:</label>
        <input type="text" name="username" class="border w-full p-2 mb-3"/>

        <label class="block">Password:</label>
        <input type="password" name="password" class="border w-full p-2 mb-4"/>

        <button class="bg-blue-600 text-white px-4 py-2 rounded">Login</button>
    </form>
</div>

<jsp:include page="includes/footer.jsp" />
