<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List of clients</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<jsp:include page="errorCatcher.jsp"></jsp:include>
<c:choose>
    <c:when test="${empty clients.client }">
        <h2>No clients found</h2>
    </c:when>
    <c:otherwise>
        <div>
            <c:forEach var="client" items="${clients.client }">
                <div class="vertical-container">
                    <a href="view?id=${client.id}"><h1>${client.name} ${client.surname}</h1></a>
                    <b>date of birth: ${client.dateOfBirth}</b>
                    <b>Photo ${client.photo}</b>
                   <i>Subscription ${client.currentSubscription.startDate}</i>
                    <i>End date ${client.currentSubscription.endDate}</i>
                    <i>Price ${client.currentSubscription.price}</i>
                    <i>Coach name ${client.currentSubscription.coach.name}</i>
                    <i>Coach surname ${client.currentSubscription.coach.surname}</i>
                    <i>Coach experience ${client.currentSubscription.coach.experience}</i>

                    <form action="delete" method="post">
                        <input type="hidden" name="id" value="${client.id }">
                        <input type="submit" value="Delete">
                    </form>
                    <a href="update?id=${client.id}">Edit</a>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>
</body>
</html>