<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty errorMsg }">
    <div class="error-container">
        <h2>${errorMsg}</h2>
    </div>
</c:if>
<% session.removeAttribute("errorMsg"); %>

