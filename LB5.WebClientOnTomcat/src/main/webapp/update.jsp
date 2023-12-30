<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update post</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
	<jsp:include page="errorCatcher.jsp"></jsp:include>
 	<div>
 		<form action="update?id=${client.id}" method="post" class="vertical-container">
			<label for="name">Name: </label>
			<input type="text" id="name" name="name" />
			<label for="surname">Surname: </label>
			<textarea id="surname" name="surname"></textarea>

			<label for="dateOfBirth">DateOfBirth: </label>
			<input type="text" name="dateOfBirth" id="dateOfBirth" />
			<label for="photo">Photo link: </label>
			<input type="text" id="photo" name="photo" />

			<label for="subscription" id="subscription">Subscription: </label>
			<label for="startDate">Start date: </label>
			<input type="text" id="startDate" name="startDate"/>
			<label for="endDate">End date: </label>
			<input type="text" id="endDate" name="endDate"/>
			<label for="price">Price: </label>
			<input type="text" id="price" name="price"/>

			<label for="coach" id="coach">Coach: </label>
			<label for="coach_name">Coach name: </label>
			<input type="text" id="coach_name" name="coach_name"/>
			<label for="coach_surname">Coach surname: </label>
			<input type="text" id="coach_surname" name="coach_surname"/>
			<label for="experience">Coach experience: </label>
			<input type="text" id="experience" name="experience"/>

 			<input type="submit" value="Update" />
 		</form>
 	</div>
</body>
</html>