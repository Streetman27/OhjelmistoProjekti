<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kysymys Haettu</title>
</head>
<body>
<h1>Tässä näet kaikki kysymykset</h1>
	
<c:forEach items="${kysymys}" var="kys">
	<tr>
		<td><c:out value="${kys.id}"/></td>
		<td><c:out value="${kys.kysymys}"/></td>
		<td><c:out value="${kys.kysymys_tyyppi.maaritelma}"/></td>
		<td><input type="${kys.kysymys_tyyppi.maaritelma}" name="vastausmuoto" value="${kys.kysymys_tyyppi.id}"></td>
	</tr>
</c:forEach>

	<p>
	<a href="..">Takaisin etusivulle</a>
	</p>
</body>
</html>