<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View a Client</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
	<jsp:include page="errorCatcher.jsp"></jsp:include>
 	<c:choose>
 	<c:when test="${not empty errorMsg }">
		<h2>${errorMsg }</h2>
 	</c:when>
	<c:otherwise>
		<div class="vertical-container">
			<h1>${client.name}</h1>
			<span>${client.surname}</span>
			<b>Id ${client.id}</b>
			<b>Date OF birth: ${client.dateOfBirth}</b>
			<i>Start Date ${client.currentSubscription.startDate}</i>
			<i>End Date ${client.currentSubscription.endDate}</i>
			<i>Price ${client.currentSubscription.price}</i>
			<b>Coach:</b>
			<i>Coach name ${client.currentSubscription.coach.name}</i>
			<i>Coach surname ${client.currentSubscription.coach.surname}</i>
			<i>Coach experience ${client.currentSubscription.coach.experience}</i>
			<form action="delete" method="post">
				<input type="hidden" name="id" value="${client.id }">
				<input type="submit" value="Delete">
			</form>
			<a href="update?id=${client.id}">Edit</a>
		</div>
	</c:otherwise>
	</c:choose>
	
	<% session.removeAttribute("client"); %>
</body>
</html>