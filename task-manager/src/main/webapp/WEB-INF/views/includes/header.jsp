<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Manager</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<nav class="bg-blue-600 text-white p-4">
    <div class="container mx-auto">
        <a href="<c:url value='/tasks' />" class="font-semibold">Task Manager</a>

        <c:if test="${not empty sessionScope.username}">
            <span class="ml-6">Hi, ${sessionScope.username}</span>
            <a href="<c:url value='/logout' />" class="ml-4 underline">Logout</a>
        </c:if>
    </div>
</nav>

<div class="container mx-auto mt-6">
