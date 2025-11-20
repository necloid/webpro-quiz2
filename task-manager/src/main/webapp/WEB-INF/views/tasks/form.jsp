<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../includes/header.jsp" />

<h1 class="text-2xl font-bold mb-4">
    <c:if test="${empty task}">Create Task</c:if>
    <c:if test="${not empty task}">Edit Task</c:if>
</h1>

<form method="post">
    <input type="hidden" name="id" value="${task.id}" />

    <label>Title:</label>
    <input type="text" name="title" class="border w-full p-2 mb-3" value="${task.title}" required />

    <label>Description:</label>
    <textarea name="description" class="border w-full p-2 mb-3">${task.description}</textarea>

    <label>Priority:</label>
    <select name="priority" class="border w-full p-2 mb-3">
        <option ${task.priority=="LOW"?"selected":""}>LOW</option>
        <option ${task.priority=="MEDIUM"?"selected":""}>MEDIUM</option>
        <option ${task.priority=="HIGH"?"selected":""}>HIGH</option>
    </select>

    <label>Status:</label>
    <select name="status" class="border w-full p-2 mb-3">
        <option ${task.status=="TODO"?"selected":""}>TODO</option>
        <option ${task.status=="IN_PROGRESS"?"selected":""}>IN_PROGRESS</option>
        <option ${task.status=="DONE"?"selected":""}>DONE</option>
    </select>

    <label>Due Date:</label>
    <input type="date" name="dueDate" class="border w-full p-2 mb-3" value="${task.dueDate}" />

    <label>Category:</label>
    <select name="categoryId" class="border w-full p-2 mb-3">
        <option value="">-- None --</option>
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}" ${task.categoryId == c.id ? "selected" : ""}>
                ${c.name}
            </option>
        </c:forEach>
    </select>

    <label>Project:</label>
    <select name="projectId" class="border w-full p-2 mb-3">
        <option value="">-- None --</option>
        <c:forEach var="p" items="${projects}">
            <option value="${p.id}" ${task.projectId == p.id ? "selected" : ""}>
                ${p.name}
            </option>
        </c:forEach>
    </select>

    <button class="bg-blue-600 text-white px-4 py-2 rounded">Save</button>
</form>

<jsp:include page="../includes/footer.jsp" />
